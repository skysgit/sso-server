package com.cn.app.server.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cn.app.server.service.UserCenterRouteService;


@RestController
public class UserCenterController {

	private static final Logger logger = LoggerFactory.getLogger(UserCenterController.class);
    
    public static final String CHARTFORINF = "UTF-8";
    public static final String POST_KEY = "jsondata";
    
    @Autowired
    private UserCenterRouteService userCenterRouteService;
    
	@SuppressWarnings("rawtypes")
    @RequestMapping(value = "/user-interface", method = RequestMethod.POST)
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
	    List ioList = IOUtils.readLines(request.getInputStream());
        String userJSON = "";
        logger.info("-------------服务调用开始---------------");

        String userJSONTemp = (String) request.getAttribute(POST_KEY);

        String ip = request.getRemoteHost();
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        String id = session != null ? session.getId().toUpperCase() : "";

        String infoPre = "[CommServer:" + id + "]";
        long timeBegin = System.currentTimeMillis();

        logger.info(infoPre + " Begin - IP: " + ip + "; URI: " + url);

        try {
        	logger.info("oList.size() ：" + ioList.size());
            StringBuilder sb = new StringBuilder(1024);
            for (int i = 0; i < ioList.size(); i++) {
                sb.append(ioList.get(i));
            }
            userJSON = userJSONTemp;
            if (userJSON == null) {
                userJSON = sb.toString();
            }
            // 进行转码
            userJSON = URLDecoder.decode(userJSON, CHARTFORINF);

            logger.info("接到原始接口信息：" + userJSON);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error reading:" + e.toString(), e);
        }

        logger.info("接口处理开始");
        String responseMessage = userCenterRouteService.userCenterRoute(userJSON);
        logger.info("接口处理结束");
        
        logger.info("返回原始接口信息=" + responseMessage);
        // 进行编码处理
        responseMessage = URLEncoder.encode(responseMessage, CHARTFORINF);

        //UserCenterInfController.logger.info("responseMessage=" + responseMessage);
        byte[] byteMessages = responseMessage.getBytes();
        try {
            OutputStream outputStream = response.getOutputStream();
            response.setContentType("text/html; charset=UTF-8");
            response.setContentLength(byteMessages.length);
            outputStream.write(byteMessages);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error sending JSON: " + e.toString(), e);
        }

        long timeEnd = System.currentTimeMillis();
        logger.info("服务总响应时间 ：" + infoPre + " End   - Seconds: " + (timeEnd - timeBegin) / 1000.0D);

        logger.info("-------------服务调用结束---------------");

        return null;
	}
}
