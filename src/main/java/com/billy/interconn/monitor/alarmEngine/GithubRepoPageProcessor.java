package com.billy.interconn.monitor.alarmEngine;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: bandd
 * Mailto:bandd@haier.com
 * On: 2017/6/30  17:13
 */
public class GithubRepoPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        System.out.println("author:"+page.getResultItems().get("author"));


        //公司名
        page.putField("company-name", page.getHtml().xpath("//div[@class='header fl-clr']/dl/dt/strong/text()").toString());
        System.out.println("company-name:"+        page.getResultItems().get("company-name"));

        //联系人
        page.putField("contact-man", page.getHtml().xpath("//div[@class='left-intro']/span/text()").toString());
        System.out.println("contact-man:"+        page.getResultItems().get("contact-man"));

        //职位头衔
        page.putField("job-title", page.getHtml().xpath("//div[@class='right-intro']/ul/li[1]/text()").toString());
        System.out.println("job-title:"+        page.getResultItems().get("job-title"));

        //电话座机
        page.putField("Telephone", page.getHtml().xpath("//div[@class='right-intro']/ul/li[2]/h2/text()").toString());
        System.out.println("Telephone:"+        page.getResultItems().get("Telephone"));

        //手机
        page.putField("mobile", page.getHtml().xpath("//div[@class='right-intro']/ul/li[3]/h1/text()").toString());
        System.out.println("mobile:"+        page.getResultItems().get("mobile"));

        //地址
//        page.putField("address", page.getHtml().xpath("//div[@class='right-intro']/ul/li[5]/text()").toString());
        page.putField("address", page.getHtml().xpath("//div[@class='right-intro']/ul/html()").toString());
        System.out.println("address:"+        page.getResultItems().get("address"));

        //公司首页
        page.putField("Showroom", page.getHtml().xpath("//div[@class='right-intro']/ul/li[6]/text()").toString());
        System.out.println("Showroom:"+        page.getResultItems().get("Showroom"));


       // https://trade.china.cn/Rubber-Sheets/apcrubber/contacts.html
        page.addTargetRequest(" https://trade.china.cn/Rubber-Sheets/apcrubber/contacts.html");

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {



        Spider.create(new GithubRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
//                .addUrl("https://trade.china.cn/Other-Woodworking-Machinery/qdzhongding/contacts.html")
                .addUrl((String[]) getAllUrl(46,"https://trade.china.cn/search/corp_qingdao.html?p=").toArray())
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();
    }


    private static List<String> getAllUrl(int count,String finalString){
        List<String> aList = new ArrayList<String>();
        for(int i=0;i<count;i++){
            aList.add(finalString+i);
        }
        return aList;

    }
}
