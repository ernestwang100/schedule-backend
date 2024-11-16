package com.ernest.schedule.service.impl;

import com.ernest.schedule.dao.SysUserDao;
import com.ernest.schedule.dao.impl.SysUserDaoImpl;
import com.ernest.schedule.pojo.SysUser;
import com.ernest.schedule.service.SysUserService;
import com.ernest.schedule.utils.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysUserDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {

//        transfer password to MD5
        sysUser.setPassword(MD5Util.encrypt(sysUser.getPassword()));
//        save password to the db
        return sysUserDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }
}
