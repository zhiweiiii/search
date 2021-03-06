package com.dabaicai.search.api.controller;

import com.dabaicai.search.common.entity.CrawlWhichHtml;
import com.dabaicai.search.common.service.CrawlService;
import com.dabaicai.search.common.vo.inputvo.CrawlHtmlInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhiwei
 * @date 2019/4/18 13:44
 */
@Component("crawlRunner")
@Order(value=1)
public class CrawlRunner implements CommandLineRunner {

    Logger logger= LoggerFactory.getLogger(CrawlRunner.class);

    @Autowired
    CrawlService crawlService;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("crawlRunner开始启动");
        List<CrawlWhichHtml> whichHtmls = crawlService.getCrawlHtml();
        for (CrawlWhichHtml whichHtml : whichHtmls) {
            CrawlHtmlInputVo crawlHtmlInputVo=new CrawlHtmlInputVo();
            crawlHtmlInputVo.setHtml(whichHtml.getHtml());
            crawlHtmlInputVo.setHostId(whichHtml.getId());
            crawlService.CrawlFromHtml(crawlHtmlInputVo);
        }
    }


}
