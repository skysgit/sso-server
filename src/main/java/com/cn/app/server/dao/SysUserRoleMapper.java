package com.cn.app.server.dao;

import com.cn.app.server.model.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}