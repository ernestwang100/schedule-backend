package com.ernest.schedule.test;

import com.ernest.schedule.dao.BaseDao;
import com.ernest.schedule.pojo.SysSchedule;
import com.ernest.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestBaseDao {

    private static BaseDao baseDao;

    @BeforeClass
    public static  void inintBaseDao() {
        baseDao = new BaseDao();
    }

//    @Test
//    public void testBaseDao() {
//        String sql = "select count(1) from sys_user";
//        Long count = baseDao.baseQueryObject(Long.class, sql);
//        System.out.println(count);
//    }

    @Test
    public void testBaseQuery() {
        String sql = "select uid, username, user_pwd userPwd from sys_user";
        List<Object> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_schedule values(DEFAULT, ?,?,?)";

        int rows = baseDao.baseUpdate(sql, "1", "test", 0);
        System.out.println(rows);
    }
}
