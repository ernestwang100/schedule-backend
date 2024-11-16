package com.ernest.schedule.test;

import com.ernest.schedule.dao.SysScheduleDao;
import com.ernest.schedule.dao.impl.SysScheduleDaoImpl;
import com.ernest.schedule.pojo.SysSchedule;
import org.junit.Test;

import java.util.List;

public class TestSysScheduleDao {
    private static SysScheduleDao sysScheduleDao = new SysScheduleDaoImpl();
    public void initScheduleDao() {
        sysScheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule(){
        int rows = sysScheduleDao.addSchedule(new SysSchedule(null, 2, "learn dbms", 1));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        List<SysSchedule> list = sysScheduleDao.findAll();
        list.forEach(System.out::println);
    }
}
