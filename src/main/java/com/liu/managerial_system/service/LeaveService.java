package com.liu.managerial_system.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liu.managerial_system.domain.Forleave;
import com.liu.managerial_system.domain.ForleaveExample;
import com.liu.managerial_system.domain.User;
import com.liu.managerial_system.domain.UserExample;
import com.liu.managerial_system.dto.ForleaveDto;
import com.liu.managerial_system.dto.UserDto;
import com.liu.managerial_system.mapper.ForleaveMapper;
import com.liu.managerial_system.mapper.UserMapper;
import com.liu.managerial_system.service.public_service.LeavePublicService;
import com.liu.managerial_system.util.CopyUtil;
import com.liu.managerial_system.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/5 22:57
 */
@Service
public class LeaveService {
    @Resource
    private ForleaveMapper forleaveMapper;
    @Resource
    private LeavePublicService leavePublicService;

    @Resource
    private UserMapper userMapper;
    @Autowired
    private HttpServletRequest request;

    public void applyForLeave(ForleaveDto forleaveDto) {
        forleaveDto.setId(UuidUtil.getShortUuid());
        forleaveDto.setApproval("0");
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(forleaveDto.getUsername());
        List<User> list = userMapper.selectByExample(userExample);
        forleaveDto.setDepartment(list.get(0).getDepartment());
        forleaveMapper.insert(CopyUtil.copy(forleaveDto, Forleave.class));
    }

    public int[] getTodayAllLeaveMsg() {
        return leavePublicService.getTodayAllLeaveMsg();
    }

    public String ifShortOut(String userId, String states) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(Integer.parseInt(userId));
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() == 1) {
            UserDto userDto = CopyUtil.copy(userList.get(0), UserDto.class);
            userDto.setOut(states);
            if (states.equals("0")) {
                userDto.setOuttime("0");
            } else {
                userDto.setOuttime(new Date().getTime() + "");
            }
            userMapper.updateByExampleSelective(CopyUtil.copy(userDto, User.class), userExample);
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user", userDto);
        }
        return states;
    }

    public String getShortOutList() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("outtime desc");
        userExample.createCriteria().andOutNotEqualTo("0");
        List<User> userList = userMapper.selectByExample(userExample);
        List<UserDto> userDtoList = CopyUtil.copyList(userList, UserDto.class);
        JSONArray jsonArray = new JSONArray();
        if (userDtoList != null && userDtoList.size() != 0) {
            for (UserDto userDto : userDtoList) {
                JSONObject jsonObject = new JSONObject();
                long outTime = Long.parseLong(userDto.getOuttime());
                long newTime = new Date().getTime();
                long duration = newTime - outTime;
//                long days = duration / (1000 * 60 * 60 * 24);
                long hours = duration / (1000 * 60 * 60);
                long minutes = (duration - hours * (1000 * 60 * 60)) / (1000 * 60);
                String out = "";
                if (hours == 0 && minutes < 5) {
                    out = "刚刚";
                } else {
                    out = hours + "小时" + minutes + "分钟前";
                }
                jsonObject.put("out", out);
                jsonObject.put("username", userDto.getUsername());
                switch (userDto.getOut()) {
                    case "1":
                        jsonObject.put("reason", "去上课");
                        break;
                    case "2":
                        jsonObject.put("reason", "外出办事，稍后回来");
                        break;
                }
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        }
        return null;
    }

    public String getTodayLeaveMsgByDepart(String department) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String date = simpleDateFormat.format(new Date());
        ForleaveExample forleaveExample = new ForleaveExample();
        forleaveExample.createCriteria().andDepartmentEqualTo(department).andStartdayLessThanOrEqualTo(date).andEnddayGreaterThanOrEqualTo(date);
        List<Forleave> forleaveList = forleaveMapper.selectByExample(forleaveExample);
        String msg = "";
        if (forleaveList != null && forleaveList.size() > 0) {
            for (Forleave forleave : forleaveList) {
                msg = msg + forleave.getUsername() + "  请假原因：" + forleave.getReason() + "</br>";
            }
        } else {
            msg = department + "今日无人请假";
        }
        return msg;
    }

    public String getUserLeaveMsgByDuration(String username, String duration) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
        String today = formatDate.format(new Date());
        String date = leavePublicService.getSomeMonthAgo(duration);

        ForleaveExample forleaveExample = new ForleaveExample();
        forleaveExample.createCriteria().andUsernameEqualTo(username).andEnddayGreaterThanOrEqualTo(date).andStartdayLessThanOrEqualTo(today);
        List<Forleave> forleaveList = forleaveMapper.selectByExample(forleaveExample);
        String msg = "";
        for (Forleave forleave : forleaveList) {
            msg = msg + forleave.getUsername() + "  " + forleave.getReason() + "  " + forleave.getStartday() + "——" + forleave.getEndday() + "<br>";
        }
        return msg;
    }

    public String getHistoryAttendance(String which) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
        String today = formatDate.format(new Date());
        String date = leavePublicService.getSomeMonthAgo(which);


        ForleaveExample forleaveExample = new ForleaveExample();
        forleaveExample.createCriteria().andEnddayGreaterThanOrEqualTo(date).andStartdayLessThanOrEqualTo(today);

        List<Forleave> forleaveList = forleaveMapper.selectByExample(forleaveExample);
        JSONArray jsonArray = new JSONArray();

        Map<String, Long> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

        for (Forleave forleave : forleaveList) {
            String startDay = forleave.getStartday();
            String endDay = forleave.getEndday();
            try {
                long days = (simpleDateFormat.parse(endDay).getTime() - simpleDateFormat.parse(startDay).getTime()) / (1000 * 60 * 60 * 24);
                if (!map.containsKey(forleave.getUsername())) {
                    map.put(forleave.getUsername(), days + 1);
                } else {
                    days = days + map.get(forleave.getUsername());
                    map.put(forleave.getUsername(), days + 1);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", entry.getKey());
            jsonObject.put("value", entry.getValue());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    public List<ForleaveDto> getAllLeave() {
        ForleaveExample forleaveExample = new ForleaveExample();
        return CopyUtil.copyList(forleaveMapper.selectByExample(forleaveExample), ForleaveDto.class);
    }

    public List<ForleaveDto> getMyLeaveMsg(String username) {
        ForleaveExample forleaveExample = new ForleaveExample();
        forleaveExample.createCriteria().andUsernameEqualTo(username);
        return CopyUtil.copyList(forleaveMapper.selectByExample(forleaveExample), ForleaveDto.class);
    }
}
