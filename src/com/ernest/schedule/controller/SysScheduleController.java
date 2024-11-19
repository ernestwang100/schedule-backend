package com.ernest.schedule.controller;

import com.ernest.schedule.common.Result;
import com.ernest.schedule.pojo.SysSchedule;
import com.ernest.schedule.service.SysScheduleService;
import com.ernest.schedule.service.impl.SysScheduleServiceImpl;
import com.ernest.schedule.utils.WebUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private final SysScheduleService scheduleService = new SysScheduleServiceImpl();

    public void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) {
        int uid = Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);
        WebUtil.writeJson(resp, Result.ok(itemList));

    }

    public void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) {
        int uid = Integer.parseInt(req.getParameter("uid"));
        Integer result = scheduleService.addDefault(uid);
        WebUtil.writeJson(resp, Result.ok(result));
    }

    public void updateSchedule(HttpServletRequest req, HttpServletResponse resp) {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        Integer result = scheduleService.updateSchedule(sysSchedule);
        WebUtil.writeJson(resp, Result.ok(result));
    }

    public void deleteSchedule(HttpServletRequest req, HttpServletResponse resp) {
        int sid = Integer.parseInt(req.getParameter("sid"));
        Integer result = scheduleService.deleteSchedule(sid);
        WebUtil.writeJson(resp, Result.ok(result));
    }
}
