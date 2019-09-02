package com.dabaicai.search.common.service;

import com.dabaicai.search.common.entity.CrawlChildHtml;
import com.dabaicai.search.common.entity.CrawlWhichHtml;
import com.dabaicai.search.common.vo.inputvo.CrawlHtmlInputVo;
import com.dabaicai.search.common.vo.output.CrawlHtmlOutputVo;

import java.util.List;

public interface CrawlService {

    //获取链接
    public List<CrawlWhichHtml> getCrawlHtml();

    //处理链接
    public CrawlHtmlOutputVo CrawlFromHtml(CrawlHtmlInputVo crawlHtmlInputVo);

    public List<CrawlChildHtml> getCrawlChildHtml();



}
