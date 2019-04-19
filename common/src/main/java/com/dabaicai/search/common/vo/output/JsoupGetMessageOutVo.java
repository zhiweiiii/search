package com.dabaicai.search.common.vo.output;

import java.util.List;

/**
 * @author zhiwei
 * @date 2019/4/19 10:32
 */
public class JsoupGetMessageOutVo {

    public String title;

    public String html;

    public List<String> childHtmls;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<String> getChildHtmls() {
        return childHtmls;
    }

    public void setChildHtmls(List<String> childHtmls) {
        this.childHtmls = childHtmls;
    }


}
