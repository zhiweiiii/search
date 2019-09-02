package com.dabaicai.search.api.mapper;

import com.dabaicai.search.common.entity.CrawlChildHtml;
import com.dabaicai.search.common.entity.CrawlChildHtmlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrawlChildHtmlMapper {
    long countByExample(CrawlChildHtmlExample example);

    int deleteByExample(CrawlChildHtmlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrawlChildHtml record);

    int insertSelective(CrawlChildHtml record);

    List<CrawlChildHtml> selectByExample(CrawlChildHtmlExample example);

    CrawlChildHtml selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrawlChildHtml record, @Param("example") CrawlChildHtmlExample example);

    int updateByExample(@Param("record") CrawlChildHtml record, @Param("example") CrawlChildHtmlExample example);

    int updateByPrimaryKeySelective(CrawlChildHtml record);

    int updateByPrimaryKey(CrawlChildHtml record);
}