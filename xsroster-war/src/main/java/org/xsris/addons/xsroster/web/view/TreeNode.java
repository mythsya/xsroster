package org.xsris.addons.xsroster.web.view;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	public static final TreeNode buildLeafNode(String id, String name, boolean open) {
		TreeNode node = new TreeNode();
		node.setId(id);
		node.setName(name);
		node.setIsParent(false);
		node.setOpen(open);
		return node;
	}

	public static final TreeNode buildParentNode(String id, String name, boolean open) {
		TreeNode node = new TreeNode();
		node.setId(id);
		node.setName(name);
		node.setIsParent(true);
		node.setOpen(open);
		return node;
	}

	private String id;
	private String name;
	private Boolean isParent = false;
	private Boolean open = false;
	private String target;
	private String url;
	private String icon;
	private List<TreeNode> children = new ArrayList<TreeNode>();

	public List<TreeNode> getChildren() {
		return children;
	}

	public String getIcon() {
		return icon;
	}

	public String getId() {
		return id;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public String getName() {
		return name;
	}

	public Boolean getOpen() {
		return open;
	}

	public String getTarget() {
		return target;
	}

	public String getUrl() {
		return url;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
