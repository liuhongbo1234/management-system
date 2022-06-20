package com.liu.managerial_system.mapper;

import com.liu.managerial_system.domain.UserTask;
import com.liu.managerial_system.domain.UserTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTaskMapper {
    long countByExample(UserTaskExample example);

    int deleteByExample(UserTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserTask record);

    int insertSelective(UserTask record);

    List<UserTask> selectByExample(UserTaskExample example);

    UserTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByExample(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKey(UserTask record);
}