package com.liu.util;

import com.liu.pojo.TextMessage;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * Created by anybody on 2017/1/4.
 */
public class TextMessageUtil {


    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    public static String initText(String toUserName, String fromUserName, String content) {
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType("text");
        textMessage.setCreateTime(DateUtil.formatDate(new Date()));
        textMessage.setContent(content);
        return TextMessageUtil.textMessageToXml(textMessage);
    }

    //关注后消息
    public static String initMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("亲，都等你好久了!\n");
        sb.append("回复'?'查看所有服务哟！");
        return sb.toString();
    }

    //主菜单
    public static String mainMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("请按照菜单提示操作！\n\n");
        sb.append("1、天气\n");
        sb.append("2、电影\n");
        sb.append("6、翻译\n");
        sb.append("回复?查看此菜单！");
        return sb.toString();
    }

    public static String firstMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("天气晴转多云！");
        return sb.toString();
    }

    public static String secondMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("新电影‘侠盗一号’很不错哟！");
        return sb.toString();
    }

    public static String unknownContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("我们不知道你在说什么，请回复'?'查看主菜单！");
        return sb.toString();
    }

    public static String leaveContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("亲爱的，我们真的舍不得你离开，不要走嘛！");
        return sb.toString();
    }


}
