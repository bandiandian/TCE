package com.billy.interconn.monitor.alarmEngine.spider;

import com.billy.interconn.monitor.alarmEngine.excel.WriteExcel;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 新版webmagic
 * Author: bandd
 * Mailto:bandd@haier.com
 * On: 2017/7/4  17:13
 */
public class GithubRepoPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private  List<Map> list=null;

    GithubRepoPageProcessor(List<Map> toExcelContentList){

        this.list = toExcelContentList;
    }

;

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {


        String prefix_url = "contacts.html";


        //div[@class='right-intro']/ul/li[5]/
        String next_page_xpath = "//div[@class='list-detail fl-clr']/div/span/a/@href";

        if(page.getHtml().xpath(next_page_xpath).match()){
            System.out.println("进入到getHtml页面");
            Selectable nextPageUrl = page.getHtml().xpath(next_page_xpath);
            List<String> realContactList = new ArrayList<String>();
            for(String oneProduct:nextPageUrl.all()){
                System.out.println("oneProduct info:"+oneProduct);
                oneProduct = oneProduct+prefix_url;
                realContactList.add(oneProduct);
            }
            page.addTargetRequests(realContactList);

        }else{


            page.putField("contactInfo", page.getHtml().xpath("//div[@class='right-intro']/ul/html()").toString());
            System.out.println("contactInfo:"+ page.getResultItems().get("contactInfo"));


            //联系人
            page.putField("contact-man", page.getHtml().xpath("//div[@class='left-intro']/span/text()").toString());
            System.out.println("contact-man:"+        page.getResultItems().get("contact-man"));

            String contactMan  =  page.getResultItems().get("contact-man");



            String contactInfo  = page.getResultItems().get("contactInfo");

            if(null!=contactInfo){
                System.out.println("去掉html:"+contactInfo.replaceAll("<li>|<label>|</li>|</h2>|<h1>|</h1>","").replaceAll("</label>",":"));
                String  afterHtml = contactInfo.replaceAll("<li>|<label>|</li>|</h2>|<h1>|</h1>|<h2>","").replaceAll("</label>",":");

                if(null!=afterHtml&&afterHtml!=""){
                    System.out.println("afterHtml:"+afterHtml);
                   String[] contents =  afterHtml.split("\n");
                    System.out.println("contents.length:"+contents.length);

                    if(null!=contents&&contents.length>0){
                        Map<String,String> map=new HashMap<String,String>();
                        for(int i=0;i<contents.length;i++){
                            String oneContent = contents[i];
                           String[] oneContentArray = oneContent.split(":",2);
                            map.put(oneContentArray[0],oneContentArray[1]);

                        }
                        map.put("contact-man",contactMan);//联系人信息
                        list.add(map);
                    }

                }



            }

        }




    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        List<Map> list= new ArrayList<Map>();

        List<String> abc = getAllUrl(46,"https://trade.china.cn/search/corp_qingdao.html?p=");


        Spider.create(new GithubRepoPageProcessor(list))
                //从"https://github.com/code4craft"开始抓
//                .addUrl("https://trade.china.cn/Other-Woodworking-Machinery/qdzhongding/contacts.html")
                .addUrl(abc.toArray(new String[abc.size()]))
                //开启5个线程抓取
                .thread(1)
                //启动爬虫
                .run();


        System.out.println("list.size:"+list.size());


        try {
            WriteExcel.writeToExcel("D:/青岛本地1111.xls","sheet1",list);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private static List<String> getAllUrl(int count,String finalString){
        List<String> aList = new ArrayList<String>();
        for(int i=1;i<count;i++){
            aList.add(finalString+i);
        }
        return aList;

    }
}
