package com.dabaicai.search.api.mapper;

import com.dabaicai.search.common.entity.SucStudent;
import com.dabaicai.search.common.entity.SucStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SucStudentMapper {
    long countByExample(SucStudentExample example);

    int deleteByExample(SucStudentExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(SucStudent record);

    int insertSelective(SucStudent record);

    List<SucStudent> selectByExample(SucStudentExample example);

    SucStudent selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") SucStudent record, @Param("example") SucStudentExample example);

    int updateByExample(@Param("record") SucStudent record, @Param("example") SucStudentExample example);

    int updateByPrimaryKeySelective(SucStudent record);

    int updateByPrimaryKey(SucStudent record);
}