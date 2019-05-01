package com.hxzy.hrsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class NodeTree {
	private int id;
	private int pid;
	private String name;
	private boolean open;
	private boolean isParent;
	List<NodeTree> children = new ArrayList<NodeTree>();


	public NodeTree(int id, int pid, String name, boolean open, boolean isParent) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public List<NodeTree> getChildren() {
		return children;
	}

	public void setChildren(List<NodeTree> children) {
		this.children = children;
	}

	
	
}
