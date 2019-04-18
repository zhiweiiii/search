package com.dabaicai.search.api.serviceImpl;

import com.dabaicai.search.common.service.CrawlService;
import com.dabaicai.search.common.vo.output.CrawlHtmlOutputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhiwei
 * @date 2019/4/18 14:53
 */
@Component
public class CrawlServiceImpl implements CrawlService {

    Logger logger = LoggerFactory.getLogger(CrawlServiceImpl.class);

    @Override
    public List<String> getCrawlHtml() {
        logger.debug("调用CrawlServiceImpl开始获取html");



        return null;
    }

    @Override
    public CrawlHtmlOutputVo CrawlFromHtml() {
        return null;
    }
}
