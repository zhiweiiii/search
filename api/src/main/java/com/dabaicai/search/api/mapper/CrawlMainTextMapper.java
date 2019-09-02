package com.dabaicai.search.api.mapper;

import com.dabaicai.search.common.entity.CrawlMainText;
import com.dabaicai.search.common.entity.CrawlMainTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrawlMainTextMapper {
    long countByExample(CrawlMainTextExample example);

    int deleteByExample(CrawlMainTextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrawlMainText record);

    int insertSelective(CrawlMainText record);

    List<CrawlMainText> selectByExampleWithBLOBs(CrawlMainTextExample example);

    List<CrawlMainText> selectByExample(CrawlMainTextExample example);

    CrawlMainText selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrawlMainText record, @Param("example") CrawlMainTextExample example);

    int updateByExampleWithBLOBs(@Param("record") CrawlMainText record, @Param("example") CrawlMainTextExample example);

    int updateByExample(@Param("record") CrawlMainText record, @Param("example") CrawlMainTextExample example);

    int updateByPrimaryKeySelective(CrawlMainText record);

    int updateByPrimaryKeyWithBLOBs(CrawlMainText record);

    int updateByPrimaryKey(CrawlMainText record);
}