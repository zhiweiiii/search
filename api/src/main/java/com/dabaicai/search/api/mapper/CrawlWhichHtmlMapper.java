package com.dabaicai.search.api.mapper;

import com.dabaicai.search.api.entity.CrawlWhichHtml;
import com.dabaicai.search.api.entity.CrawlWhichHtmlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrawlWhichHtmlMapper {
    long countByExample(CrawlWhichHtmlExample example);

    int deleteByExample(CrawlWhichHtmlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrawlWhichHtml record);

    int insertSelective(CrawlWhichHtml record);

    List<CrawlWhichHtml> selectByExample(CrawlWhichHtmlExample example);

    CrawlWhichHtml selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrawlWhichHtml record, @Param("example") CrawlWhichHtmlExample example);

    int updateByExample(@Param("record") CrawlWhichHtml record, @Param("example") CrawlWhichHtmlExample example);

    int updateByPrimaryKeySelective(CrawlWhichHtml record);

    int updateByPrimaryKey(CrawlWhichHtml record);
}