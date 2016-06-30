package com.tinet.radius.modules.disconnectcause.dao;

import com.tinet.radius.common.persistence.CrudDao;
import com.tinet.radius.common.persistence.annotation.MyBatisDao;
import com.tinet.radius.modules.disconnectcause.entity.RadiusDisconnectcause;

/**
 * 故障对照表类描述DAO接口
 * @author 王贵宇
 * @version 2016-06-28
 */
@MyBatisDao
public interface RadiusDisconnectcauseDao extends CrudDao<RadiusDisconnectcause> {
	
}