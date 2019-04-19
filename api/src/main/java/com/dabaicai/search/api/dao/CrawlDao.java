package com.dabaicai.search.api.dao;

/**
 * @author zhiwei
 * @date 2019/4/18 17:44
 */

import com.dabaicai.search.common.entity.CrawlWhichHtml;
import com.dabaicai.search.common.entity.CrawlWhichHtmlExample;
import com.dabaicai.search.api.mapper.CrawlWhichHtmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrawlDao {

    @Autowired
    CrawlWhichHtmlMapper crawlWhichHtmlMapper;


    public List<CrawlWhichHtml> getAllWhichHtml(){
        CrawlWhichHtmlExample example=new CrawlWhichHtmlExample();
        example.createCriteria().andHtmlIsNotNull();
        List<CrawlWhichHtml> selectResult =crawlWhichHtmlMapper.selectByExample(example);
        return selectResult;
    }

}
