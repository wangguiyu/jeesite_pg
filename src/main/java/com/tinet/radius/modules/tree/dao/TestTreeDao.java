package com.tinet.radius.modules.tree.dao;

import com.tinet.radius.common.persistence.TreeDao;
import com.tinet.radius.common.persistence.annotation.MyBatisDao;
import com.tinet.radius.modules.tree.entity.TestTree;

/**
 * treeDAO接口
 * @author tree
 * @version 2016-06-29
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}