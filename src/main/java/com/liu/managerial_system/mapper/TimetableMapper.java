package com.liu.managerial_system.mapper;

import com.liu.managerial_system.domain.Timetable;
import com.liu.managerial_system.domain.TimetableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimetableMapper {
    long countByExample(TimetableExample example);

    int deleteByExample(TimetableExample example);

    int deleteByPrimaryKey(String id);

    int insert(Timetable record);

    int insertSelective(Timetable record);

    List<Timetable> selectByExample(TimetableExample example);

    Timetable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Timetable record, @Param("example") TimetableExample example);

    int updateByExample(@Param("record") Timetable record, @Param("example") TimetableExample example);

    int updateByPrimaryKeySelective(Timetable record);

    int updateByPrimaryKey(Timetable record);
}