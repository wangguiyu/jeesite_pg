/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tinet.radius.modules.gen.dao;

import com.tinet.radius.common.persistence.CrudDao;
import com.tinet.radius.common.persistence.annotation.MyBatisDao;
import com.tinet.radius.modules.gen.entity.GenScheme;

/**
 * 生成方案DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenSchemeDao extends CrudDao<GenScheme> {
	
}
