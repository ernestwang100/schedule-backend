package com.ernest.schedule.service.impl;

import com.ernest.schedule.dao.SysScheduleDao;
import com.ernest.schedule.dao.impl.SysScheduleDaoImpl;
import com.ernest.schedule.pojo.SysSchedule;
import com.ernest.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao sysScheduleDao = new SysScheduleDaoImpl();

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return sysScheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addSchedule(int uid) {
        return 0;
    }

    @Override
    public Integer addDefault(int uid) {
        return sysScheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        return sysScheduleDao.updateSchedule(sysSchedule);
    }

    @Override
    public Integer deleteSchedule(int sid) {
        return sysScheduleDao.deleteSchedule(sid);
    }

}
