package com.cn.app.server.dao;

import com.cn.app.server.model.SysRoleResource;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(Integer roleResId);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    SysRoleResource selectByPrimaryKey(Integer roleResId);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
}