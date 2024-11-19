package com.ernest.schedule.dao.impl;

import com.ernest.schedule.dao.BaseDao;
import com.ernest.schedule.dao.SysUserDao;
import com.ernest.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT, ?,?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUser_pwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid, username, user_pwd from sys_user where username = ?";
//        String sql = "select * from sys_user";

        List<SysUser> list = baseQuery(SysUser.class, sql, username);

        return list != null && list.size() > 0 ? list.get(0) : null;
    }
}
