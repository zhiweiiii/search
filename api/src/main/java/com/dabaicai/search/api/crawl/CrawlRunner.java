package com.dabaicai.search.api.crawl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhiwei
 * @date 2019/4/18 13:44
 */
@Component("crawlRunner")
public class CrawlRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("test success");
    }
}
