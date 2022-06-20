package com.liu.managerial_system.mapper;

import com.liu.managerial_system.domain.Achievement;
import com.liu.managerial_system.domain.AchievementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AchievementMapper {
    long countByExample(AchievementExample example);

    int deleteByExample(AchievementExample example);

    int deleteByPrimaryKey(String id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    List<Achievement> selectByExample(AchievementExample example);

    Achievement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByExample(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);
}