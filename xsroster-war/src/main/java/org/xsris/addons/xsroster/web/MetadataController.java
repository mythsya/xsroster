package org.xsris.addons.xsroster.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xsris.addons.xsroster.entity.coding.CodingCode;
import org.xsris.addons.xsroster.service.CodingCodeService;

@RestController
public class MetadataController {

	@Autowired
	@Qualifier("codingCodeService")
	private CodingCodeService codingCodeService;

	@RequestMapping("/codingcode/count")
	@Transactional(readOnly = true)
	public Integer count() {
		List<CodingCode> results = (List<CodingCode>) codingCodeService.findAll();
		return results.size();
	}
}
