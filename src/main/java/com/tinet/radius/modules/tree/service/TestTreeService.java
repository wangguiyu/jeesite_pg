package com.tinet.radius.modules.tree.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinet.radius.common.service.TreeService;
import com.tinet.radius.common.utils.StringUtils;
import com.tinet.radius.modules.tree.entity.TestTree;
import com.tinet.radius.modules.tree.dao.TestTreeDao;

/**
 * treeService
 * @author tree
 * @version 2016-06-29
 */
@Service
@Transactional(readOnly = true)
public class TestTreeService extends TreeService<TestTreeDao, TestTree> {

	public TestTree get(String id) {
		return super.get(id);
	}
	
	public List<TestTree> findList(TestTree testTree) {
		if (StringUtils.isNotBlank(testTree.getParentIds())){
			testTree.setParentIds(","+testTree.getParentIds()+",");
		}
		return super.findList(testTree);
	}
	
	@Transactional(readOnly = false)
	public void save(TestTree testTree) {
		super.save(testTree);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestTree testTree) {
		super.delete(testTree);
	}
	
}