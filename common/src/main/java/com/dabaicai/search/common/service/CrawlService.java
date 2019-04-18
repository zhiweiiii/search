package com.dabaicai.search.common.service;

import com.dabaicai.search.common.vo.output.CrawlHtmlOutputVo;

import java.util.List;

public interface CrawlService {

    //获取链接
    public List<String> getCrawlHtml();

    //处理链接
    public CrawlHtmlOutputVo CrawlFromHtml();



}
