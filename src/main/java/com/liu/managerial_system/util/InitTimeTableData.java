package com.liu.managerial_system.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liu.managerial_system.domain.Forleave;
import com.liu.managerial_system.dto.TimetableDto;

import java.util.List;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/4 18:28
 */
public class InitTimeTableData {
    public static String setTimetableData(List<TimetableDto> list, List<Forleave> forleaveList, String username) {
        JSONArray jsonArray = new JSONArray();
        for (TimetableDto timetableDto : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", timetableDto.getId());
            switch (timetableDto.getChanged()) {
                case "-1":
                    jsonObject.put("className", "label-danger");
                    break;
                case "0":
                    jsonObject.put("className", "label-primary");
                    break;
                case "1":
                    jsonObject.put("className", "label-success");
                    break;
            }
            jsonObject.put("allDay", "true");
            String date = "";
            if (timetableDto.getDate().equals("0")) {
                date = TimeUtil.getDateByDayOfWeek(timetableDto.getWeek().split("-")[0], timetableDto.getDayofweek());
            } else {
                date = timetableDto.getDate();
            }
            jsonObject.put("start", date);
            jsonObject.put("end", date);
            jsonObject.put("label", "class");
            if (username != null) {
                jsonObject.put("title", timetableDto.getCoursename() + "/" + timetableDto.getTime() + "/" + timetableDto.getPlace() + "/" + timetableDto.getSpecialty());
            } else {
                jsonObject.put("title", timetableDto.getUsername() + "/" + timetableDto.getCoursename() + "/" + timetableDto.getTime() + "/" + timetableDto.getPlace() + "/" + timetableDto.getSpecialty());
            }
            jsonArray.add(jsonObject);
        }
        if (forleaveList != null) {
            for (Forleave forleave : forleaveList) {
                JSONObject jsonObjectLeave = new JSONObject();
                jsonObjectLeave.put("id", forleave.getId());
                jsonObjectLeave.put("title", forleave.getReason());
                jsonObjectLeave.put("start", forleave.getStartday());
                jsonObjectLeave.put("end", forleave.getEndday());
                jsonObjectLeave.put("allDay", "true");
                switch (forleave.getApproval()) {
                    case "0":
                        jsonObjectLeave.put("className", "label-info");
                        break;
                    case "1":
                        jsonObjectLeave.put("className", "label-success");
                        break;
                    case "-1":
                        jsonObjectLeave.put("className", "label-danger");
                        break;
                }
                jsonArray.add(jsonObjectLeave);
            }
        }
        return jsonArray.toString();
    }
}
