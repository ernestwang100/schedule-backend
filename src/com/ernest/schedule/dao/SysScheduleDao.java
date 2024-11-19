package com.ernest.schedule.dao;

/*

 */

import com.ernest.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    /**
     * add one schedule record
     * @param schedule
     * @return
     */

    int addSchedule(SysSchedule schedule);

    /**
     * search all the schedule
     * @return put all the schedule in a list: List<SysSchedule></SysSchedule>
     */

    List<SysSchedule> findAll();

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    Integer deleteSchedule(int sid);
}

