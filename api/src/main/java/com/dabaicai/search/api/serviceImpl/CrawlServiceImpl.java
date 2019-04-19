package com.dabaicai.search.api.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.dabaicai.search.api.dao.CrawlDao;
import com.dabaicai.search.api.helper.JsoupConnectHelper;
import com.dabaicai.search.common.entity.CrawlWhichHtml;
import com.dabaicai.search.common.service.CrawlService;
import com.dabaicai.search.common.vo.output.CrawlHtmlOutputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhiwei
 * @date 2019/4/18 14:53
 */
@Component
public class CrawlServiceImpl implements CrawlService {

    Logger logger = LoggerFactory.getLogger(CrawlServiceImpl.class);

    @Autowired
    CrawlDao crawlDao;

    @Override
    public List<CrawlWhichHtml> getCrawlHtml() {
        logger.debug("调用CrawlServiceImpl开始获取html");
        List<CrawlWhichHtml> whichHtml=crawlDao.getAllWhichHtml();
        logger.debug("调用CrawlServiceImpl的结果是"+ JSON.toJSONString(whichHtml));
        return whichHtml;
    }

    @Override
    @Async
    public CrawlHtmlOutputVo CrawlFromHtml(CrawlWhichHtml whichHtml) {
        logger.debug("多线程异步调用了CrawlFromHtml,html链接为{}",whichHtml.getHtml());
        String message=JsoupConnectHelper.getMessageFromHtml(whichHtml.getHtml());


        return null;
    }
}
