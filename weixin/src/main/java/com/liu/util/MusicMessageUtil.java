package com.liu.util;

import com.liu.pojo.Music;
import com.liu.pojo.MusicMessage;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * Created by anybody on 2017/1/7.
 */
public class MusicMessageUtil {
    public static String musicMessageToXml(MusicMessage musicMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", musicMessage.getClass());
        xStream.alias("Music", new Music().getClass());
        return xStream.toXML(musicMessage);
    }

    public static String initMusicMessage(String toUserName, String fromUserName){
        String ThumbMediaId  = "_h54ua_dhJSQfQ3R1TEZMxbPULb5REdduYfZbnUFZOXNDDwCQl1lAF9SryXxSusA";
        Music music = new Music();
        music.setDescription("Stay Alive");
        music.setHQMusicUrl("http://yyhnap.ngrok.cc/weixin/music/高橋李依 - Stay Alive.mp3");
        music.setMusicUrl("http://yyhnap.ngrok.cc/weixin/music/高橋李依 - Stay Alive.mp3");
        music.setTitle("魔女的祝福");
        music.setThumbMediaId(ThumbMediaId);

        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setMusic(music);
        musicMessage.setCreateTime(DateUtil.formatDate(new Date()));
        musicMessage.setMsgType(MessageType.MESSAGE_MUSIC);
        musicMessage.setFromUserName(toUserName);
        musicMessage.setToUserName(fromUserName);
        return musicMessageToXml(musicMessage);
    }
}
