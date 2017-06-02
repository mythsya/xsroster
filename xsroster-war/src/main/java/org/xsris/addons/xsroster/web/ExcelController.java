package org.xsris.addons.xsroster.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xsris.addons.xsroster.web.view.TreeNode;

@Controller
@RequestMapping("/excel")
public class ExcelController {

	@ResponseBody
	@RequestMapping("history/tree")
	public List<TreeNode> listHistoryTree() {
		TreeNode node1 = TreeNode.buildParentNode("1", "2017", true);
		TreeNode node11 = TreeNode.buildLeafNode("11", "放射科3月6-3月12日排班表", false);
		TreeNode node12 = TreeNode.buildLeafNode("12", "放射科4月1-4月7日排班表", false);
		node1.getChildren().add(node11);
		node1.getChildren().add(node12);

		TreeNode node2 = TreeNode.buildParentNode("2", "2016", true);
		TreeNode node21 = TreeNode.buildLeafNode("21", "放射科3月6-3月12日排班表", false);
		TreeNode node22 = TreeNode.buildLeafNode("22", "放射科4月1-4月7日排班表", false);
		node2.getChildren().add(node21);
		node2.getChildren().add(node22);

		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(node1);
		list.add(node2);
		return list;
	}

	@RequestMapping("save")
	public String save(@RequestParam(name = "id", required = false) String id, @RequestParam("name") String name,
			@RequestParam("jsonCotent") String jsonCotent, @RequestParam("xlsxContent") MultipartFile xlsxContent,
			@RequestParam("path") String path) {

		return "/success";
	}
}
