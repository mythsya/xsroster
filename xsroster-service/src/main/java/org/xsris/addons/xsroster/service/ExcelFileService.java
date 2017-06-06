package org.xsris.addons.xsroster.service;

import java.util.List;

import org.xsris.addons.xsroster.entity.excel.ExcelFile;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevisionOutput;

public interface ExcelFileService {

	List<ExcelFile> listAllExcelFiles(boolean validOnly, boolean publishedOnly);

	ExcelFile openExcel(String id);

	boolean publish(String id, List<ExcelFileRevisionOutput> outputs);

	ExcelFile saveExcel(String id, String name, String tag, String path, byte[] excelContent, String jsonContent);

	ExcelFile takeSnapshot(String id, String name, String snapshot, byte[] excelContent, String jsonContent);

}
