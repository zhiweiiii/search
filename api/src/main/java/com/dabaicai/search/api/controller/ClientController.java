package com.dabaicai.search.api.controller;

import com.dabaicai.search.common.util.Result;
import com.dabaicai.search.common.util.ResultCode;
import com.dabaicai.search.common.vo.inputvo.CrawlHtmlInputVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {

    @Value("22")
    String key1;
    @Value("11")
    String key2;
    @Value("33")
    String key3;

    @RequestMapping("/com/dabaicai/search/api")
    public Result test(CrawlHtmlInputVo vo) {

        Result result=new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功返回信息");
        result.setObject(vo);
        return result;
    }

}
