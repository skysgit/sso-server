package com.cn.app.server.dao;

import com.cn.app.server.model.SysLog;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}