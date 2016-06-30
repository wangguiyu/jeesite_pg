package com.tinet.radius.modules.disconnectcause.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinet.radius.common.persistence.Page;
import com.tinet.radius.common.service.CrudService;
import com.tinet.radius.modules.disconnectcause.entity.RadiusDisconnectcause;
import com.tinet.radius.modules.disconnectcause.dao.RadiusDisconnectcauseDao;

/**
 * 故障对照表类描述Service
 * @author 王贵宇
 * @version 2016-06-28
 */
@Service
@Transactional(readOnly = true)
public class RadiusDisconnectcauseService extends CrudService<RadiusDisconnectcauseDao, RadiusDisconnectcause> {

	public RadiusDisconnectcause get(String id) {
		return super.get(id);
	}
	
	public List<RadiusDisconnectcause> findList(RadiusDisconnectcause radiusDisconnectcause) {
		return super.findList(radiusDisconnectcause);
	}
	
	public Page<RadiusDisconnectcause> findPage(Page<RadiusDisconnectcause> page, RadiusDisconnectcause radiusDisconnectcause) {
		return super.findPage(page, radiusDisconnectcause);
	}
	
	@Transactional(readOnly = false)
	public void save(RadiusDisconnectcause radiusDisconnectcause) {
		super.save(radiusDisconnectcause);
	}
	
	@Transactional(readOnly = false)
	public void delete(RadiusDisconnectcause radiusDisconnectcause) {
		super.delete(radiusDisconnectcause);
	}
	
}