package com.liu.util;

import com.liu.pojo.News;
import com.liu.pojo.NewsMessage;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anybody on 2017/1/5.
 */
public class NewsMessageUtil {
    /**
     * 图文消息转换为xml
     *
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);
    }

    public static String initNewsMessage(String toUserName, String fromUserName) {
        String message = null;
        List<News> newsList = new ArrayList<>();
        NewsMessage newsMessage = new NewsMessage();

        News news = new News();
        news.setTitle("公众号登陆提醒");
        news.setDescription("操作者:yyh_ly,如果不是你的操作，请尽快修改密码！");
        news.setPicUrl("http://yyhnap.ngrok.cc/weixin/images/u454514gp0.jpg");
        news.setUrl("https://github.com/");

        newsList.add(news);

        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(DateUtil.formatDate(new Date()));
        newsMessage.setMsgType(MessageType.MESSAGE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());

        message = newsMessageToXml(newsMessage);
        return message;
    }
}
