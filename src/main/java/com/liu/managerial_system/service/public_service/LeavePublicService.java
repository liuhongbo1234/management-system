package com.liu.managerial_system.service.public_service;

import com.liu.managerial_system.domain.Forleave;
import com.liu.managerial_system.domain.ForleaveExample;
import com.liu.managerial_system.dto.ForleaveDto;
import com.liu.managerial_system.dto.UserDto;
import com.liu.managerial_system.mapper.ForleaveMapper;
import com.liu.managerial_system.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/6 17:25
 */
@Service
public class LeavePublicService {
    @Resource
    ForleaveMapper forleaveMapper;
    @Resource
    UserPublicService userPublicService;

    public int[] getTodayAllLeaveMsg() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String today = simpleDateFormat.format(date);
        ForleaveExample forleaveExample = new ForleaveExample();
        forleaveExample.createCriteria().andStartdayLessThanOrEqualTo(today).andEnddayGreaterThanOrEqualTo(today);
        List<Forleave> forleaveList = forleaveMapper.selectByExample(forleaveExample);
        List<ForleaveDto> forleaveDtos = CopyUtil.copyList(forleaveList, ForleaveDto.class);
        List<UserDto> userDtoList = userPublicService.getAllUserList();
        Map<String, Integer> mapEveryDepartment = new HashMap<>();
        mapEveryDepartment.put("指挥信息", 0);
        mapEveryDepartment.put("卫星通信", 0);
        mapEveryDepartment.put("信息网络", 0);
        mapEveryDepartment.put("信息服务", 0);
        for (UserDto userDto : userDtoList) {
            int number = mapEveryDepartment.get(userDto.getDepartment());
            number = countNumber(number, userDto.getDepartment());
            mapEveryDepartment.put(userDto.getDepartment(), number);
        }
        Map<String, Integer> mapEveryDepartmentLeave = new HashMap<>();
        mapEveryDepartmentLeave.put("指挥信息", 0);
        mapEveryDepartmentLeave.put("卫星通信", 0);
        mapEveryDepartmentLeave.put("信息网络", 0);
        mapEveryDepartmentLeave.put("信息服务", 0);
        for (ForleaveDto forleaveDto : forleaveDtos) {
            if (!forleaveDto.getDepartment().equals("办公室")) {
                int number = mapEveryDepartmentLeave.get(forleaveDto.getDepartment());
                number = countNumber(number, forleaveDto.getDepartment());
                mapEveryDepartmentLeave.put(forleaveDto.getDepartment(), number);
            }
        }
        String[] departArray = {"信息网络", "指挥信息", "信息服务", "卫星通信"};
        int[] msg = new int[8];
        for (int i = 0; i < 4; i++) {
            msg[i] = mapEveryDepartment.get(departArray[i]) - mapEveryDepartmentLeave.get(departArray[i]);
            msg[i + 4] = mapEveryDepartmentLeave.get(departArray[i]);
        }
        return msg;
    }

    public int countNumber(int number, String department) {
        switch (department) {
            case "指挥信息":
                number++;
                break;
            case "卫星通信":
                number++;
                break;
            case "信息网络":
                number++;
                break;
            case "信息服务":
                number++;
                break;
        }
        return number;
    }

    public String getSomeMonthAgo(String which) {
        String date = "";
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
        switch (which) {
            case "1":
                Calendar cal1 = Calendar.getInstance();
                cal1.add(Calendar.MONTH, -1);    //得到前一个月
                long oneMonthAgo = cal1.getTimeInMillis();
                date = formatDate.format(new Date(oneMonthAgo));
                break;
            case "2":
                Calendar cal2 = Calendar.getInstance();
                cal2.add(Calendar.MONTH, -3);    //得到前三个月
                long threeMonthAgo = cal2.getTimeInMillis();
                date = formatDate.format(new Date(threeMonthAgo));
                break;
            case "3":
                Calendar cal3 = Calendar.getInstance();
                cal3.add(Calendar.MONTH, -6);    //得到前六个月
                long sixMonthAgo = cal3.getTimeInMillis();
                date = formatDate.format(new Date(sixMonthAgo));
                break;
        }
        return date;
    }

}
