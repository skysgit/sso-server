package com.cn.app.server.dao;

import com.cn.app.server.model.SysRolePermision;

public interface SysRolePermisionMapper {
    int deleteByPrimaryKey(Integer rolePermId);

    int insert(SysRolePermision record);

    int insertSelective(SysRolePermision record);

    SysRolePermision selectByPrimaryKey(Integer rolePermId);

    int updateByPrimaryKeySelective(SysRolePermision record);

    int updateByPrimaryKey(SysRolePermision record);
}