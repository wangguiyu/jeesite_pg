package com.tinet.radius.modules.disconnectcause.entity;


import com.tinet.radius.common.persistence.DataEntity;

/**
 * 故障对照表类描述Entity
 * @author 王贵宇
 * @version 2016-06-28
 */
public class RadiusDisconnectcause extends DataEntity<RadiusDisconnectcause> {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;		// 故障编码
	private String errorCause;		// 故障原因
	
	public RadiusDisconnectcause() {
		super();
	}

	public RadiusDisconnectcause(String id){
		super(id);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorCause() {
		return errorCause;
	}

	public void setErrorCause(String errorCause) {
		this.errorCause = errorCause;
	}
	
}