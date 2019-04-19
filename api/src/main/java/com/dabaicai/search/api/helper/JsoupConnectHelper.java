package com.dabaicai.search.api.helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * @author zhiwei
 * @date 2019/4/19 9:55
 */

public final class JsoupConnectHelper {

    public static String getMessageFromHtml(String html) throws Exception{
        Document doc=Jsoup.connect(html).timeout(5000).get();
        String title=doc.title();
        List<String> childhtmls=getChildHtmls(doc);
        return null;
    }
    public static List<String> getChildHtmls(Document doc){

    }

}
