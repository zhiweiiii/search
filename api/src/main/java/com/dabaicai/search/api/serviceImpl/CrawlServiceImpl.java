package com.dabaicai.search.api.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.dabaicai.search.api.dao.CrawlDao;
import com.dabaicai.search.api.helper.JsoupConnectHelper;
import com.dabaicai.search.common.entity.CrawlChildHtml;
import com.dabaicai.search.common.entity.CrawlWhichHtml;
import com.dabaicai.search.common.service.CrawlService;
import com.dabaicai.search.common.vo.inputvo.CrawlHtmlInputVo;
import com.dabaicai.search.common.vo.output.CrawlHtmlOutputVo;
import com.dabaicai.search.common.vo.output.JsoupGetMessageOutVo;
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
    public CrawlHtmlOutputVo CrawlFromHtml(CrawlHtmlInputVo inputVoHtml) {
        logger.info("多线程异步调用了CrawlFromHtml,html链接为{}",inputVoHtml.getHtml());
        try{
            JsoupGetMessageOutVo jsoupGetMessage=JsoupConnectHelper.getMessageFromHtml(inputVoHtml);
            int insertMainTextResult=crawlDao.insertMainText(jsoupGetMessage);
            logger.info("成功的插入{}条数据到主查询数据库CrawlMainText中",insertMainTextResult);
            int deleteFromMainText=crawlDao.deleteFromMainText(jsoupGetMessage);
            logger.info("从子数据库中删除了{}条数据",deleteFromMainText);
            int count=crawlDao.insertJsoupMessage(jsoupGetMessage);
            logger.info("成功插入了{}条信息到子数据库中",count);
        }
        catch (Exception e){
            logger.error("发生了异常，异常信息为:{}",e);
        }

        return null;
    }

    @Override
    public List<CrawlChildHtml> getCrawlChildHtml() {
        logger.debug("调用CrawlServiceImpl开始获取html");
        List<CrawlChildHtml> childHtml=crawlDao.getAllChildHtml();
        logger.debug("调用CrawlServiceImpl的结果是"+ JSON.toJSONString(childHtml));
        return childHtml;
    }

}
