package com.liu.managerial_system.service;

import com.liu.managerial_system.domain.Forleave;
import com.liu.managerial_system.domain.ForleaveExample;
import com.liu.managerial_system.domain.Timetable;
import com.liu.managerial_system.domain.TimetableExample;
import com.liu.managerial_system.dto.TimetableDto;
import com.liu.managerial_system.mapper.ForleaveMapper;
import com.liu.managerial_system.mapper.TimetableMapper;
import com.liu.managerial_system.util.CopyUtil;
import com.liu.managerial_system.util.InitTimeTableData;
import com.liu.managerial_system.util.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/4 14:42
 */
@Service
public class TimetableService {
    @Resource
    private TimetableMapper timetableMapper;
    @Resource
    private ForleaveMapper forleaveMapper;

    public String getTimetableByName(String username) {
        TimetableExample timetableExample = new TimetableExample();
        ForleaveExample forleaveExample = new ForleaveExample();
        List<Forleave> forleaveList = null;
        if (username != null) {
            timetableExample.createCriteria().andUsernameEqualTo(username);
            forleaveExample.createCriteria().andUsernameEqualTo(username);
            forleaveList = forleaveMapper.selectByExample(forleaveExample);
        } else {
            timetableExample.createCriteria().getAllCriteria();
        }
        List<Timetable> timetableList = timetableMapper.selectByExample(timetableExample);
        return InitTimeTableData.setTimetableData(CopyUtil.copyList(timetableList, TimetableDto.class), forleaveList, username);
    }

    public void changeClass(TimetableDto timetableDto) {
        TimetableDto newTimetableDto = new TimetableDto();
        newTimetableDto.setId(timetableDto.getOldid());
        newTimetableDto.setChanged("-1");
        // 更新旧课标志
        timetableMapper.updateByPrimaryKeySelective(CopyUtil.copy(newTimetableDto, Timetable.class));
        // 新的课程安排
        timetableDto.setId(UuidUtil.getShortUuid());
        timetableDto.setChanged("1");
        timetableMapper.insert(CopyUtil.copy(timetableDto, Timetable.class));
    }
}
