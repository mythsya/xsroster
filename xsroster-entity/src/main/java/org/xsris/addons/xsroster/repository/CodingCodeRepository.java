package org.xsris.addons.xsroster.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xsris.addons.xsroster.entity.coding.CodingCode;

@Repository
public interface CodingCodeRepository extends CrudRepository<CodingCode, String> {

	Page<CodingCode> findAll(Pageable pageable);

}
