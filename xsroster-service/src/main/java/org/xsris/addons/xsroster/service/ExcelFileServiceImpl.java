package org.xsris.addons.xsroster.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.xsris.addons.xsroster.entity.excel.ExcelFile;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevision;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevisionOutput;
import org.xsris.addons.xsroster.repository.excel.ExcelFileRepository;
import org.xsris.addons.xsroster.repository.excel.ExcelFileRevisionOutputRepository;
import org.xsris.addons.xsroster.repository.excel.ExcelFileRevisionRepository;

@Component("excelFileService")
public class ExcelFileServiceImpl implements ExcelFileService {

	@Autowired
	private ExcelFileRepository excelFileRepository;

	@Autowired
	private ExcelFileRevisionRepository excelFileRevisionRepository;

	@Autowired
	private ExcelFileRevisionOutputRepository excelFileRevisionOutputRepository;

	@Transactional
	@Override
	public boolean deleteExcel(ExcelFile excel) {
		Assert.notNull(excel, "ExcelFile entity must not be null !");

		excel.getRevisions().clear();

		excelFileRepository.delete(excel);

		return true;
	}

	@Override
	public List<ExcelFile> listAllExcelFiles(boolean validOnly, boolean publishedOnly) {
		Sort sort = new Sort(new Order(Direction.DESC, "createdWhen"), new Order(Direction.DESC, "name"));
		if (validOnly || publishedOnly) {
			ExcelFile e = new ExcelFile();
			if (validOnly) {
				e.setValid(true);
			}
			if (publishedOnly) {
				e.setPublished(true);
			}
			return excelFileRepository.findAll(Example.of(e), sort);
		} else {
			return excelFileRepository.findAll(sort);
		}
	}

	@Override
	public ExcelFile openExcel(String id) {
		if (StringUtils.isNotEmpty(id)) {
			ExcelFile file = excelFileRepository.findOne(id);
			if (file != null) {
				ExcelFileRevision rev = file.getCurrentRevision();
				rev.getJsonContent();
				rev.getExcelContent();
			}
			return file;
		}
		return null;
	}

	@Override
	public ExcelFileRevisionOutput openExcelOutput(String id) {
		if (StringUtils.isNotEmpty(id)) {
			return excelFileRevisionOutputRepository.findOne(id);
		}
		return null;
	}

	@Transactional
	@Override
	public boolean publish(String id, List<ExcelFileRevisionOutput> outputs) {
		if (StringUtils.isNotEmpty(id) && (outputs != null) && !outputs.isEmpty()) {
			ExcelFile file = excelFileRepository.findOne(id);
			if (file != null) {
				ExcelFileRevision rev = excelFileRevisionRepository.findOne(file.getCurrentRevision().getId());
				Assert.notNull(rev, "ExcelFileRevision can not be null in case ExcelFile is not null !");

				DateTime now = DateTime.now();

				for (ExcelFileRevisionOutput output : outputs) {
					output.setId(null);
					output.setCreatedWhen(now);
					output.setExcelFileRevision(rev);
				}

				rev.getOutputs().clear();
				rev.getOutputs().addAll(outputs);
				rev.setPublished(true);
				rev.setModifiedWhen(now);

				excelFileRevisionRepository.save(rev);

				file.setPublished(true);
				file.setModifiedWhen(now);
				excelFileRepository.save(file);

				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public ExcelFile saveExcel(String id, String name, String tag, String path, byte[] excelContent,
			String jsonContent) {

		DateTime now = DateTime.now();
		ExcelFileRevision rev = null;
		ExcelFile file = null;

		if (StringUtils.isNotEmpty(id)) {
			file = excelFileRepository.findOne(id);
			if (file != null) {
				rev = excelFileRevisionRepository.findOne(file.getCurrentRevision().getId());
				Assert.notNull(rev, "ExcelFileRevision can not be null in case ExcelFile is not null !");
			}
		}

		if (file == null) {
			file = new ExcelFile();
			file.setCreatedWhen(now);
			file.setValid(true);

			rev = new ExcelFileRevision();
			rev.setCreatedWhen(now);
			rev.setExcelFile(file);

			file.getRevisions().add(rev);
			file.setCurrentRevision(rev);
		} else {
			file.setModifiedWhen(now);

			rev.setModifiedWhen(now);
		}
		rev.setPublished(false);
		rev.setName(name);
		rev.setJsonContent(jsonContent);
		rev.setExcelContent(excelContent);

		file.setName(name);
		file.setTag(tag);
		file.setPublished(false);
		excelFileRepository.save(file);

		return file;
	}

	@Override
	public ExcelFile takeSnapshot(String id, String name, String snapshot, byte[] excelContent, String jsonContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
