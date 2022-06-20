package com.liu.managerial_system.mapper;

import com.liu.managerial_system.domain.Forleave;
import com.liu.managerial_system.domain.ForleaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForleaveMapper {
    long countByExample(ForleaveExample example);

    int deleteByExample(ForleaveExample example);

    int deleteByPrimaryKey(String id);

    int insert(Forleave record);

    int insertSelective(Forleave record);

    List<Forleave> selectByExample(ForleaveExample example);

    Forleave selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Forleave record, @Param("example") ForleaveExample example);

    int updateByExample(@Param("record") Forleave record, @Param("example") ForleaveExample example);

    int updateByPrimaryKeySelective(Forleave record);

    int updateByPrimaryKey(Forleave record);
}