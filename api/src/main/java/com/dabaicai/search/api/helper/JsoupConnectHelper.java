package com.dabaicai.search.api.helper;

import com.dabaicai.search.common.entity.CrawlWhichHtml;
import com.dabaicai.search.common.vo.inputvo.CrawlHtmlInputVo;
import com.dabaicai.search.common.vo.output.JsoupGetMessageOutVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhiwei
 * @date 2019/4/19 9:55
 */

public final class JsoupConnectHelper {

    public static JsoupGetMessageOutVo getMessageFromHtml(CrawlHtmlInputVo crawlHtml) throws Exception{
        Document doc=Jsoup.connect(crawlHtml.getHtml()).timeout(5000).get();
        String title=doc.title();
        List<String> childhtmls=getChildHtmlsFromDoc(doc);
        String text=getTextFromDoc(doc);
        JsoupGetMessageOutVo vo=new JsoupGetMessageOutVo();
        vo.setTitle(title);
        vo.setHtml(crawlHtml.getHtml());
        vo.setChildHtmls(childhtmls);
        vo.setText(text);
        vo.setHostId(crawlHtml.getHostId());
        return vo;
    }

    //获取子链接
    public static List<String> getChildHtmlsFromDoc(Document doc){
        List<String> childHtmls=new ArrayList<>();
        Elements aChildElements=doc.select("a[href]");
        for (Element aChildElement:aChildElements){
            String childHtml=aChildElement.attr("href");
            //去除无效结果
            if (childHtml.matches(".*(javascript:).*")|childHtml.matches("^(#).*$")){
                continue;
            }
            //修改至符合标准样式
            if (childHtml.matches("^(/|\\\\).*$")){
                Pattern p=Pattern.compile("(?<=http://|\\\\.)[^.]*?\\\\.(com|cn|net|org|biz|info|cc|tv)");
                Matcher matcher =p.matcher(doc.location());
                matcher.find();
                StringBuffer stringBuffer=new StringBuffer(matcher.group());
                stringBuffer.append(childHtml);
                childHtml=stringBuffer.toString();
            }
            else if (!childHtml.matches("^http[s]{0,1}.*$")){
                StringBuffer stringBuffer=new StringBuffer("http://");
                stringBuffer.append(childHtml);
                childHtml=stringBuffer.toString();
            }



            childHtmls.add(childHtml);

        }
        return childHtmls;
    }


    //获取正文
    public static String getTextFromDoc(Document doc){
        Pattern pattern = Pattern.compile("[^\u4E00-\u9FA5]");
        //[\u4E00-\u9FA5]是unicode2的中文区间
        Matcher matcher = pattern.matcher(doc.body().toString());
        //String text=matcher.replaceAll("");

        String text = doc.body().toString().replaceAll("[^\\u4E00-\\u9FA5]", "");  //去除数字，英文，汉字  之外的内容

        return text;
    }
}
