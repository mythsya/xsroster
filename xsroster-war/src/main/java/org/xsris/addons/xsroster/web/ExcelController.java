package org.xsris.addons.xsroster.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/excel")
public class ExcelController {

	@RequestMapping("save")
	public String save(@RequestParam("name") String name, @RequestParam("jsonCotent") String jsonCotent,
			@RequestParam("xlsxContent") String xlsxContent, @RequestParam("path") String path) {

		return "/success";
	}
}
