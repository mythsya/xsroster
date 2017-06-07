package org.xsris.addons.xsroster.repository.excel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xsris.addons.xsroster.entity.excel.ExcelFileRevisionOutput;

@Repository
public interface ExcelFileRevisionOutputRepository extends JpaRepository<ExcelFileRevisionOutput, String> {

}
