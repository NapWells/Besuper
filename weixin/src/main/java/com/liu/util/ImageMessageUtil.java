package com.liu.util;

import com.liu.pojo.Image;
import com.liu.pojo.ImageMessage;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * Created by anybody on 2017/1/5.
 */
public class ImageMessageUtil {
    public static String imageMessageToXml(ImageMessage imageMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", imageMessage.getClass());
        xStream.alias("Image", new Image().getClass());
        return xStream.toXML(imageMessage);
    }

    public static String initImageMessage(String toUserName, String fromUserName ){
        Image image = new Image();
        image.setMediaId("KQQwe-1XJtptwGkEqGvfHQDkIrerpKlqp-FXueqGeSyFeUmVpJEDTiepSde-TdNS");
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName(fromUserName);
        imageMessage.setFromUserName(toUserName);
        imageMessage.setMsgType(MessageType.MESSAGE_IMAGE);
        imageMessage.setCreateTime(DateUtil.formatDate(new Date()));
        imageMessage.setImage(image);
        return imageMessageToXml(imageMessage);
    }
}
