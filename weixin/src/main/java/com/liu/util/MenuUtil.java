package com.liu.util;

import com.google.gson.JsonObject;
import com.liu.menu.Button;
import com.liu.menu.ClickButton;
import com.liu.menu.Menu;
import com.liu.menu.ViewButton;

/**
 * Created by anybody on 2017/1/7.
 */
public class MenuUtil {
    public static Menu initMenu(){
        Menu menu = new Menu();
        ClickButton clickButton11= new ClickButton();
        clickButton11.setType(EventType.MENU_CLICK);
        clickButton11.setName("click菜单");
        clickButton11.setKey("btn11");

        ViewButton viewButton21 = new ViewButton();
        viewButton21.setType(EventType.MENU_VIEW);
        viewButton21.setName("view菜单");
        viewButton21.setUrl("http://www.baidu.com");

        ClickButton clickButton31 = new ClickButton();
        clickButton31.setName("扫码事件");
        clickButton31.setType(EventType.SCANCODE_PUSH);
        clickButton31.setKey("bt31");

        ClickButton clickButton32 = new ClickButton();
        clickButton32.setName("地理位置");
        clickButton32.setType(EventType.LOCATION_SELECT);
        clickButton32.setKey("bt32");

        Button button = new Button();
        button.setName("菜单");
        button.setSub_button(new Button[]{clickButton31,clickButton32});

        menu.setButton(new Button[]{clickButton11,viewButton21,button});
        return  menu;
    }

    public static int createMenu(String token,String menu){
        int result = 0;
        String url = UrlUtil.CREATE_MENU_URL.replace("ACCESS_TOKEN",token);
        JsonObject jsonObject = WeixinUtil.doPostStr(url,menu);
        if(jsonObject != null){
            result = jsonObject.get("errcode").getAsInt();
        }
        return result;
    }

    public static JsonObject queryMenu(String token){
        String url = UrlUtil.QUERY_MENU_URL.replace("ACCESS_TOKEN",token);
        JsonObject jsonObject = WeixinUtil.doGetStr(url);
        return jsonObject;
    }

    public static int deleteMenu(String token){
        int result = 0;
        String url = UrlUtil.DELETE_MENU_URL.replace("ACCESS_TOKEN",token);
        JsonObject jsonObject = WeixinUtil.doGetStr(url);
        if(jsonObject != null) {
            result = jsonObject.get("errcode").getAsInt();
        }
        return result;
    }

}
