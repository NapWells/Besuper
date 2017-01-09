package com.liu.util;

import com.google.gson.Gson;
import com.liu.pojo.AccessToken;
import org.junit.Test;

import java.io.IOException;

public class UtilTest {
    @Test
    public void testDoGetStr() throws Exception {
        AccessToken accessToken = WeixinUtil.getAccessToken();
        System.out.println("获取到的凭证（access_token）:"+accessToken.getToken());
        System.out.println("凭证有效时间，单位：秒（expires_in）:"+accessToken.getExpiresIn());
    }

    @Test
    public void testGetMediaId(){
        try {
            String id = MaterialUtil.upload("C:\\Users\\anybody\\Desktop\\timg.jpg",
                    WeixinUtil.getAccessToken().getToken(),MessageType.MESSAGE_THUMB);
            System.out.println(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateMenu(){
        String menu = new Gson().toJson(MenuUtil.initMenu());
        System.out.println(menu);
        String token = WeixinUtil.getAccessToken().getToken();
        int result = MenuUtil.createMenu(token,menu);
        System.out.println(result);
    }

    @Test
    public void testQueryMenu(){
        String token = WeixinUtil.getAccessToken().getToken();
        System.out.println( MenuUtil.queryMenu(token));
    }

    @Test
    public void testDeleteMenu(){
        String token = WeixinUtil.getAccessToken().getToken();
        int result = MenuUtil.deleteMenu(token);
        System.out.println(result);
    }

    @Test
    public void testTranslate() throws Exception{
//        String result = TranslateUtil.getTranslateResult("足球");
//        System.out.println(result);
        String s = "1231m,m,12414kl";
        System.out.println(s.indexOf("123"));
        System.out.println(s.substring(s.indexOf("123")+2));

    }


} 
