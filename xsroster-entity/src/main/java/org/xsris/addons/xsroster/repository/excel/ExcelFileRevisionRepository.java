package org.xsris.addons.xsroster.repository.excel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevision;

@Repository
public interface ExcelFileRevisionRepository extends JpaRepository<ExcelFileRevision, String> {

}
