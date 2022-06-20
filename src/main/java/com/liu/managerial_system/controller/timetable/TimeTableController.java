package com.liu.managerial_system.controller.timetable;

import com.liu.managerial_system.dto.TimetableDto;
import com.liu.managerial_system.service.TimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/4 14:30
 */
@RestController
@RequestMapping("/timetable")
public class TimeTableController {
    @Resource
    private TimetableService timetableService;

    @RequestMapping("/timetabledata")
    public String myTimetable(String username) {
        return timetableService.getTimetableByName(username);
    }

    @RequestMapping("/changeclass")
    public void changeClass(@ModelAttribute(value = "timetableDto") TimetableDto timetableDto) {
        Logger LOG = LoggerFactory.getLogger(TimeTableController.class);
        LOG.info(timetableDto.getCoursename());
        LOG.info(timetableDto.getUsername());
        timetableService.changeClass(timetableDto);
    }
}
