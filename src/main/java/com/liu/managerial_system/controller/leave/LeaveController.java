package com.liu.managerial_system.controller.leave;

import com.liu.managerial_system.dto.ForleaveDto;
import com.liu.managerial_system.service.LeaveService;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/2 9:06
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Resource
    private LeaveService leaveService;

    @RequestMapping("/leavedetails")
    public String everyDuratinoDetails(String which) {
        return leaveService.getHistoryAttendance(which);
    }

    @PostMapping("/leave_details_by_name")
    public String leaveDetailsByname(String username, String duration) {
        return leaveService.getUserLeaveMsgByDuration(username, duration);
    }

    @PostMapping("/applyforleave")
    public String applyForLeave(@ModelAttribute ForleaveDto forleaveDto) {
        leaveService.applyForLeave(forleaveDto);
        return "success";
    }

    @PostMapping("/todayLeaveMsgByDepartment")
    public String todayLeaveMsgByDepart(String department) {
        return leaveService.getTodayLeaveMsgByDepart(department);
    }

    @RequestMapping("/todayAllLeaveMsg")
    public int[] todayAllLeaveMsg() {
        return leaveService.getTodayAllLeaveMsg();
    }

    @PostMapping("/shortout")
    public String shortOut(String userId, String states) {
        return leaveService.ifShortOut(userId, states);
    }

    @RequestMapping("/current_state")
    public String getShortOut() {
        return leaveService.getShortOutList();
    }
}
