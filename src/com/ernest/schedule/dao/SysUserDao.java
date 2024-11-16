package com.ernest.schedule.dao;

import com.ernest.schedule.pojo.SysUser;

public interface SysUserDao {

    /**
     * add user data to db
     * @param sysUser (username, user_pwd)
     * @return sucess 1, fail 0
     */
    int addSysUser(SysUser sysUser);

    SysUser findByUsername(String username);
}
