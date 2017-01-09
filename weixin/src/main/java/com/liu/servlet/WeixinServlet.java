package com.liu.servlet;

import com.liu.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet("/weixin.do")
public class WeixinServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		System.out.println("signature:"+signature);
		System.out.println("timestamp:"+timestamp);
		System.out.println("nonce:"+nonce);
		System.out.println("echostr:"+echostr);
		PrintWriter out = response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.println(echostr);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Map<String,String> map = WeixinUtil.xmlToMap(request);
		String toUserName = map.get("ToUserName");
		String fromUserName = map.get("FromUserName");
		String msgType = map.get("MsgType");
		String content = map.get("Content");

		String message = null;
		if(MessageType.MESSAGE_TEXT.equals(msgType)){
			if("1".equals(content)){
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.firstMenu());
			}else if("2".equals(content)){
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.secondMenu());
			}else if("3".equals(content)){//图文消息
				message = NewsMessageUtil.initNewsMessage(toUserName,fromUserName);
			}else if("4".equals(content)){//图片消息
				message = ImageMessageUtil.initImageMessage(toUserName,fromUserName);
			}else if("5".equals(content)){//音乐消息
				message = MusicMessageUtil.initMusicMessage(toUserName,fromUserName);
			}else if("6".equals(content)){//翻译菜单Texe
				message = TextMessageUtil.initText(toUserName,fromUserName, TranslateUtil.translateMenu());
			}else if(content.trim().startsWith("翻译")){
				content = content.substring(2);
				message = TextMessageUtil.initText(toUserName,fromUserName, TranslateUtil.getTranslateResult(content));
			}else if("?".equals(content)||"？".equals(content)){
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.mainMenu());
			}else{
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.unknownContent());
			}
		}else if(MessageType.MESSAGE_EVENT.equals(msgType)){
			String eventType = map.get("Event");
			if(MessageType.MESSAGE_SUBSCRIBE.equals(eventType)){
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.initMenu());
			}else if(MessageType.MESSAGE_UNSUBSCRIBE.equals(eventType)){
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.leaveContent());
			}else if(MessageType.MESSAGE_CLICK.equals(eventType)){
				message = TextMessageUtil.initText(toUserName,fromUserName, TextMessageUtil.initMenu());
			}else if(MessageType.MESSAGE_VIEW.equals(eventType)){
				String url = map.get("EventKey");
				message = TextMessageUtil.initText(toUserName,fromUserName, url);
			}else if(EventType.SCANCODE_PUSH.equals(eventType)){
				String key = map.get("EventKey");
				message = TextMessageUtil.initText(toUserName,fromUserName, key);
			}
		}else if(MessageType.MESSAGE_LOCATION.equals(msgType)){
			String Label = map.get("Label");
			message = TextMessageUtil.initText(toUserName,fromUserName, Label);
		}
		System.out.println(message);
		response.getWriter().print(message);
	}

}
