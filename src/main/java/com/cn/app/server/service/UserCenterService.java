package com.cn.app.server.service;

import com.cn.app.server.base.HttpReq;
import com.cn.app.server.base.HttpResp;

public interface UserCenterService {
	/**
	 * 	登录
	 * @param httpReq
	 * @return
	 */
	public HttpResp userLogin(HttpReq httpReq);
}
