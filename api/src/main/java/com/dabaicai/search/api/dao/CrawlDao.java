package com.dabaicai.search.api.dao;

/**
 * @author zhiwei
 * @date 2019/4/18 17:44
 */

import com.dabaicai.search.api.mapper.CrawlChildHtmlMapper;
import com.dabaicai.search.api.mapper.CrawlMainTextMapper;
import com.dabaicai.search.common.entity.*;
import com.dabaicai.search.api.mapper.CrawlWhichHtmlMapper;
import com.dabaicai.search.common.vo.output.JsoupGetMessageOutVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrawlDao {

    @Autowired
    CrawlWhichHtmlMapper crawlWhichHtmlMapper;

    @Autowired
    CrawlChildHtmlMapper crawlChildHtmlMapper;

    @Autowired
    CrawlMainTextMapper crawlMainTextMapper;


    public List<CrawlWhichHtml> getAllWhichHtml(){
        CrawlWhichHtmlExample example=new CrawlWhichHtmlExample();
        example.createCriteria().andHtmlIsNotNull();
        List<CrawlWhichHtml> selectResult =crawlWhichHtmlMapper.selectByExample(example);
        return selectResult;
    }
    public List<CrawlChildHtml> getAllChildHtml(){
        CrawlChildHtmlExample example=new CrawlChildHtmlExample();
        example.createCriteria().andHtmlIsNotNull();
        List<CrawlChildHtml> selectResult =crawlChildHtmlMapper.selectByExample(example);
        return selectResult;
    }

    //子数据库插入多个子数据
    public int insertJsoupMessage(JsoupGetMessageOutVo jsoupGetMessage){
        int count=0;
        for (String html:jsoupGetMessage.getChildHtmls()){
            CrawlChildHtml crawlChildHtml=new CrawlChildHtml();
            crawlChildHtml.setHtml(html);
            crawlChildHtml.setHostId(jsoupGetMessage.getHostId());
            count+=crawlChildHtmlMapper.insert(crawlChildHtml);
        }

        return count;
    }

    //主数据库放入1个完整的数据
    public int insertMainText(JsoupGetMessageOutVo jsoupGetMessageOutVo){
        CrawlMainText crawlMainText=new CrawlMainText();
        crawlMainText.setHtml(jsoupGetMessageOutVo.html);
        crawlMainText.setText(jsoupGetMessageOutVo.getText());
        crawlMainText.setHostId(jsoupGetMessageOutVo.getHostId());
        crawlMainText.setTitle(jsoupGetMessageOutVo.getTitle());
        int result=crawlMainTextMapper.insert(crawlMainText);
        return result;
    }

    //将数据从主数据库删除
    public int deleteFromMainText(JsoupGetMessageOutVo jsoupGetMessageOutVo){
        CrawlChildHtmlExample example=new CrawlChildHtmlExample();
        example.createCriteria().andHtmlEqualTo(jsoupGetMessageOutVo.getHtml());
        int result=crawlChildHtmlMapper.deleteByExample(example);
        return result;
    }


}
