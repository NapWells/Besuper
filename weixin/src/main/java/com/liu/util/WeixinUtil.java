package com.liu.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liu.pojo.AccessToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anybody on 2017/1/5.
 */
public class WeixinUtil {
    private static final String APPID = "wx3c98c947902a2021";
    private static final String APPSECRET = "db8d8d478cd381678c037300d86d3463";


    /**
     * 将XML转化为Map集合
     *
     * @param request
     * @return
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) {
        Map<String, String> map = null;
        SAXReader reader = new SAXReader();
        InputStream in = null;
        try {
            in = request.getInputStream();
            Document document = reader.read(in);
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            map = new HashMap<>();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    //get亲求方式获取access_token
    public static JsonObject doGetStr(String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        JsonObject jsonObject = null;
        try{
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                String result = EntityUtils.toString(entity,"utf-8");
                jsonObject = new JsonParser().parse(result).getAsJsonObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    //post的请求方式获取access_token
    public static JsonObject doPostStr(String url,String outStr){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        JsonObject jsonObject = null;
        httpPost.setEntity(new StringEntity(outStr,"utf-8"));
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                jsonObject = new JsonParser().parse(result).getAsJsonObject();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取access_token
     * @return
     */
    public static AccessToken getAccessToken(){
        AccessToken accessToken = new AccessToken();
        String url = UrlUtil.ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
        JsonObject jsonObject = doGetStr(url);
        if(jsonObject != null){
            accessToken.setToken(jsonObject.get("access_token").getAsString());
            accessToken.setExpiresIn(jsonObject.get("expires_in").getAsInt());
        }
        return accessToken;
    }

}
