package org.xsris.addons.xsroster.service;

import java.util.List;

import org.xsris.addons.xsroster.entity.excel.ExcelFile;

public interface ExcelFileService {

	List<ExcelFile> listAllExcelFiles(boolean validOnly);

	ExcelFile openExcel(String id);

	ExcelFile saveExcel(String id, String name, String tag, String path, byte[] excelContent, String jsonContent);

	ExcelFile takeSnapshot(String id, String name, String snapshot, byte[] excelContent, String jsonContent);

}
