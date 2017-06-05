package org.xsris.addons.xsroster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xsris.addons.xsroster.entity.excel.ExcelFile;

@Repository
public interface ExcelFileRepository extends JpaRepository<ExcelFile, String> {

}
