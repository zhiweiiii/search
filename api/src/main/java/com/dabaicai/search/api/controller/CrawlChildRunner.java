package com.dabaicai.search.api.controller;

import com.dabaicai.search.common.entity.CrawlChildHtml;
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
@Component("crawlChildRunner")
@Order(value=2)
public class CrawlChildRunner implements CommandLineRunner {

    Logger logger= LoggerFactory.getLogger(CrawlChildRunner.class);

    @Autowired
    CrawlService crawlService;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("crawlChildRunner开始启动");
        while (true) {
            List<CrawlChildHtml> childHtmls = crawlService.getCrawlChildHtml();
            for (CrawlChildHtml childHtml : childHtmls) {
                CrawlHtmlInputVo inputVo=new CrawlHtmlInputVo();
                inputVo.setHostId(childHtml.getHostId());
                inputVo.setHtml(childHtml.getHtml());
                crawlService.CrawlFromHtml(inputVo);
            }

        }
    }


}
