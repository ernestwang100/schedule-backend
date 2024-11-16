package com.ernest.schedule.dao.impl;

import com.ernest.schedule.dao.BaseDao;
import com.ernest.schedule.dao.SysScheduleDao;
import com.ernest.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT, ?, ?, ?)";
        int rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid, uid, title, completed from sys_schedule";
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql);
        return scheduleList;
    }
}
