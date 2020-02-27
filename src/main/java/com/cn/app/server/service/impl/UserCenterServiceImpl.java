package com.cn.app.server.service.impl;

import org.springframework.stereotype.Service;

import com.cn.app.server.base.HttpReq;
import com.cn.app.server.base.HttpResp;
import com.cn.app.server.constants.UserInterfaceCode;
import com.cn.app.server.service.UserCenterService;

@Service
public class UserCenterServiceImpl implements UserCenterService{

	@Override
	public HttpResp userLogin(HttpReq httpReq) {
		HttpResp httpResp = new HttpResp();
		httpResp.setInterfaceCode(UserInterfaceCode.USER_LOGIN);
		httpResp.setCode(UserInterfaceCode.SUCCESS_CODE);
		httpResp.setMessage("http请求发送成功");
		return httpResp;
	}

	  
}
