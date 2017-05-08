package org.xsris.addons.xsroster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xsris.addons.xsroster.entity.coding.CodingCode;
import org.xsris.addons.xsroster.repository.CodingCodeRepository;

@Component("codingCodeService")
public class CodingCodeServiceImpl implements CodingCodeService {

	@Autowired
	private CodingCodeRepository codingCodeRepository;

	@Override
	public Iterable<CodingCode> findAll() {
		// TODO Auto-generated method stub
		return codingCodeRepository.findAll();
	}

}
