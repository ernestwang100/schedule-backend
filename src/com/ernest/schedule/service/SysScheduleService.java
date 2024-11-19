package com.ernest.schedule.service;

import com.ernest.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addSchedule(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    Integer deleteSchedule(int sid);

    Integer addDefault(int uid);
}
