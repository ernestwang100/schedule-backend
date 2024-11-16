package com.ernest.schedule.service;

import com.ernest.schedule.pojo.SysUser;

public interface SysUserService {
    /**
     * registration method
     * @param sysUser
     * @return sucess 1, fail 0
     */
    int regist(SysUser sysUser);

    /**
     * find the data by username
     * @param username
     * @return if find it return Sysuser, or return null
     */
    SysUser findByUsername(String username);
}
