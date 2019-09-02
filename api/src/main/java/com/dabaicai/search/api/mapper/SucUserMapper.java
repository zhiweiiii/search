package com.dabaicai.search.api.mapper;

import com.dabaicai.search.common.entity.SucUser;
import com.dabaicai.search.common.entity.SucUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SucUserMapper {
    long countByExample(SucUserExample example);

    int deleteByExample(SucUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SucUser record);

    int insertSelective(SucUser record);

    List<SucUser> selectByExample(SucUserExample example);

    SucUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SucUser record, @Param("example") SucUserExample example);

    int updateByExample(@Param("record") SucUser record, @Param("example") SucUserExample example);

    int updateByPrimaryKeySelective(SucUser record);

    int updateByPrimaryKey(SucUser record);
}