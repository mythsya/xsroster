package org.xsris.addons.xsroster.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xsris.addons.xsroster.entity.excel.ExcelFile;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevision;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevisionOutput;
import org.xsris.addons.xsroster.entity.metadata.OutputFormat;
import org.xsris.addons.xsroster.service.ExcelFileService;
import org.xsris.addons.xsroster.web.view.ExcelView;
import org.xsris.addons.xsroster.web.view.JsonResult;
import org.xsris.addons.xsroster.web.view.TreeNode;

import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.SheetRender;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

@Controller
@RequestMapping("/excel")
public class ExcelController {

	@Autowired
	private ExcelFileService excelFileService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@RequestMapping("history/tree")
	public List<TreeNode> listHistoryTree(@RequestParam(name = "validOnly", required = false) Boolean validOnly) {

		boolean showValidOnly = ((validOnly != null) && (validOnly == true));
		List<ExcelFile> files = excelFileService.listAllExcelFiles(showValidOnly);

		DateTime now = DateTime.now();
		String y = String.valueOf(now.getYear());

		List<TreeNode> list = new ArrayList<TreeNode>();
		Map<String, TreeNode> parentNodes = new HashMap<String, TreeNode>();
		if ((files != null) && !files.isEmpty()) {
			for (ExcelFile file : files) {
				TreeNode pNode = parentNodes.get(file.getTag());
				if (pNode == null) {
					pNode = TreeNode.buildParentNode(file.getTag(), file.getTag(), true);
					parentNodes.put(file.getTag(), pNode);
					list.add(pNode);
				}
				TreeNode child = TreeNode.buildLeafNode(file.getId(), file.getName(), false);
				pNode.getChildren().add(child);
			}
		}

		if (!parentNodes.containsKey(y)) {
			TreeNode pNode = TreeNode.buildParentNode(y, y, true);
			list.add(0, pNode);
		}

		return list;
	}

	@ResponseBody
	@RequestMapping("open")
	public ExcelView openExcel(@RequestParam(name = "id") String id) {
		ExcelView view = new ExcelView();
		ExcelFile file = excelFileService.openExcel(id);
		if (file != null) {
			view.setId(file.getId());
			view.setName(file.getName());
			view.setTag(file.getTag());

			ExcelFileRevision rev = file.getCurrentRevision();
			view.setRevisionId(rev.getId());
			view.setContent(rev.getJsonContent());
		}
		return view;
	}

	@ResponseBody
	@RequestMapping("publish")
	public JsonResult publish(@RequestParam(name = "id") String id) {
		List<ExcelFileRevisionOutput> outputs = new ArrayList<ExcelFileRevisionOutput>();
		ExcelFile file = excelFileService.openExcel(id);
		if (file != null) {
			ExcelFileRevision rev = file.getCurrentRevision();
			byte[] excelData = rev.getExcelContent();
			InputStream ins = null;
			try {
				ins = new ByteArrayInputStream(excelData);
				Workbook workbook = new Workbook(ins);

				ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();
				imgOptions.setSaveFormat(SaveFormat.SVG);
				imgOptions.setOnePagePerSheet(true);

				int sheetCount = workbook.getWorksheets().getCount();
				for (int i = 0; i < sheetCount; i++) {
					Worksheet sheet = workbook.getWorksheets().get(i);
					SheetRender sr = new SheetRender(sheet, imgOptions);

					for (int k = 0; k < sr.getPageCount(); k++) {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						try {
							sr.toImage(k, out);
							byte[] svgData = out.toByteArray();
							ExcelFileRevisionOutput revOut = new ExcelFileRevisionOutput();
							revOut.setSheetIndex(i);
							revOut.setData(svgData);
							revOut.setSheetName(sheet.getName());
							revOut.setFormat(OutputFormat.SVG);
							outputs.add(revOut);
						} finally {
							if (out != null) {
								IOUtils.closeQuietly(out);
							}
						}
					}
				}

				boolean result = excelFileService.publish(id, outputs);
				if (result) {
					return JsonResult.success(id, "");
				} else {
					return JsonResult.error(id, "Failed to publish the roster, caused by unexpected exception!");
				}

			} catch (Exception e) {
				logger.error("Failed to export excel file to svg files , caused by ", e);
				return JsonResult.error("1", "Failed to export excel file to svg files , caused by " + e.getMessage(),
						e);
			} finally {
				if (ins != null) {
					IOUtils.closeQuietly(ins);
				}
			}
		}

		return JsonResult.error("99", "Failed to publish excel file , caused by empty excel content !");
	}

	@ResponseBody
	@RequestMapping("save")
	public JsonResult save(@RequestParam(name = "id", required = false) String id, @RequestParam("name") String name,
			@RequestParam("tag") String tag, @RequestParam("path") String path,
			@RequestParam("jsonCotent") String jsonCotent, @RequestParam("xlsxContent") MultipartFile xlsxContent) {

		byte[] excelContent;
		try {
			excelContent = xlsxContent.getBytes();
			ExcelFile file = excelFileService.saveExcel(id, name, tag, path, excelContent, jsonCotent);
			return JsonResult.success(file.getId(), file.getName());
		} catch (Exception e) {
			logger.error("Failed to save excel file , caused by ", e);
			return JsonResult.error("1", "Failed to save excel file , caused by " + e.getMessage(), e);
		}
	}
}
