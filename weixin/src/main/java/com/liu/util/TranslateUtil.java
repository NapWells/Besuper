package com.liu.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liu.translation.TransResult;
import com.liu.translation.Translate;

/**
 * Created by anybody on 2017/1/7.
 */
public class TranslateUtil {
    private final static String APPID = "20170107000035402";
    private final static String SECRETKEY = "DP0xhyB9Bq76dFl1lkme";

    public static String getTranslateResult(String source){
        String salt = String.valueOf(System.currentTimeMillis());

        // 签名
        String src = APPID + source + salt + SECRETKEY; // 加密前的原文
        String sign = MD5.md5(src);
        String url = "http://api.fanyi.baidu.com/api/trans/vip/translate?q="+source+"&from=auto&to=auto&appid="+APPID+"&salt="+salt+"&sign="+sign+"";
        url = url.replaceAll("\\s","%20");
        JsonObject jsonObject = WeixinUtil.doGetStr(url);;
        Translate translate = new Gson().fromJson(jsonObject,Translate.class);
        StringBuffer sb = new StringBuffer();
        for(TransResult result : translate.getTrans_result()){
            sb.append(result.getDst());
        }
        return  sb.toString();
    }

    public static String translateMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("请参照翻译示例：\n");
        sb.append("翻译足球\n");
        sb.append("翻译中国人\n");
        sb.append("翻译close\n");
        sb.append("---------------------------");
        return sb.toString();
    }



}
