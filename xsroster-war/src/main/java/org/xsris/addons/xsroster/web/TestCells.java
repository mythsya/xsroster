package org.xsris.addons.xsroster.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.aspose.cells.ImageFormat;
import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.License;
import com.aspose.cells.PrintingPageType;
import com.aspose.cells.SheetRender;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class TestCells {

	private static InputStream license;
	private static InputStream fileInput;
	private static File outputFile;

	/**
	 * 获取license
	 *
	 * @return
	 */
	public static boolean getLicense() {
		boolean result = false;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			TestCells.license = new FileInputStream(loader.getResource("license.xml").getPath());// 凭证文件
			TestCells.fileInput = new FileInputStream(loader.getResource("test.xlsx").getPath());// 待处理的文件
			TestCells.outputFile = new File("e:\\test.svg");// 输出路径

			License aposeLic = new License();
			aposeLic.setLicense(TestCells.license);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// 验证License
		if (!TestCells.getLicense()) {
			return;
		}
		try {
			long old = System.currentTimeMillis();
			Workbook wb = new Workbook(TestCells.fileInput);
			// FileOutputStream fileOS = new FileOutputStream(TestCells.outputFile);
			ImageOrPrintOptions imgOpts = new ImageOrPrintOptions();
			// imgOpts.setSaveFormat(ImageFormat.getPng());
			imgOpts.setOnePagePerSheet(true);
			imgOpts.setImageFormat(ImageFormat.getJpeg());
			imgOpts.setPrintingPage(PrintingPageType.IGNORE_BLANK);

			int sheetCount = wb.getWorksheets().getCount();
			for (int i = 0; i < sheetCount; i++) {
				Worksheet sheet = wb.getWorksheets().get(i);
				SheetRender sr = new SheetRender(sheet, imgOpts);

				for (int k = 0; k < sr.getPageCount(); k++) {
					sr.toImage(k, "e:\\" + sheet.getName() + "_" + k + ".jpg");
				}
			}

			long now = System.currentTimeMillis();
			System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}