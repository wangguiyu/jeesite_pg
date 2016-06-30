package com.tinet.radius.modules.tree.entity;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tinet.radius.common.persistence.TreeEntity;

/**
 * treeEntity
 * @author tree
 * @version 2016-06-29
 */
public class TestTree extends TreeEntity<TestTree> {
	
	private static final long serialVersionUID = 1L;
	private TestTree parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
	//private String sort;		// 排序
	
	public TestTree() {
		super();
	}

	public TestTree(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public TestTree getParent() {
		return parent;
	}

	public void setParent(TestTree parent) {
		this.parent = parent;
	}
	
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
/*	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}*/
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}