package com.cn.app.server.dao;

import com.cn.app.server.model.SysResource;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Integer resId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer resId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
}