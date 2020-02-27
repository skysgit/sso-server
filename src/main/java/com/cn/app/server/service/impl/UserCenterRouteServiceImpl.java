package com.cn.app.server.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cn.app.server.base.HttpReq;
import com.cn.app.server.base.HttpResp;
import com.cn.app.server.constants.UserInterfaceCode;
import com.cn.app.server.service.UserCenterRouteService;
import com.cn.app.server.service.UserCenterService;

@Service
public class UserCenterRouteServiceImpl implements UserCenterRouteService{

	  private static final Logger logger = LoggerFactory.getLogger(UserCenterRouteService.class);
	    @Autowired
	    private UserCenterService userCenterService;

	    public String userCenterRoute(String requestMessage) {
	        //logger.info(requestMessage);
	        HttpResp httpResp = new HttpResp(); // 返回消息体
	        HttpReq httpReq;
	        if (null != requestMessage && !"".equals(requestMessage)) {

	            httpReq = JSON.parseObject(requestMessage, HttpReq.class);
	            String interfaceCode = httpReq.getInterfaceCode(); // 获取接口标识

	            Date requestTime = httpReq.getRequestTime(); // 调用接口时间
	            Timestamp requestT = new Timestamp(requestTime.getTime());
	            httpResp.setInterfaceCode(interfaceCode);

	            try {
	                if (UserInterfaceCode.USER_LOGIN.equals(interfaceCode)) {                 // 5.4.1  登录
	                    httpResp = userCenterService.userLogin(httpReq);
	                } else {
	                    httpResp.setCode("9998");
	                    httpResp.setState("0");
	                    httpResp.setMessage("未找到标识为：" + interfaceCode + "的接口定义");
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                httpResp.setCode("9998");
	                httpResp.setState("0");
	                httpResp.setMessage(e.getMessage()==null||"".equals(e.getMessage().trim())?"服务异常":e.getMessage());
	            }
	            logger.info("接口完成调用时间 耗时：" + requestT.compareTo(new Date()));
	        } else {
	            httpResp.setCode("9998");
	            httpResp.setState("0");
	            httpResp.setMessage("请求参数为空！");
	        }
	        return com.alibaba.fastjson.JSON.toJSONString(httpResp);
	    }

}
