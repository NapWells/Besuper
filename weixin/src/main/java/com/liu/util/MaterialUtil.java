package com.liu.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anybody on 2017/1/5.
 */
public class MaterialUtil {
    public static String upload(String filePath,String accessToken,String type) throws IOException {
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            throw new IOException("文件不存在！");
        }
        String url = UrlUtil.UPLOAD_URL.replace("ACCESS_TOKEN",accessToken).replace("TYPE",type);

        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);

        //设置请求头信息
        con.setRequestProperty("Connection","Keep-Alive");
        con.setRequestProperty("Charset","utf-8");

        //设置边界
        String BOUNDARRY = "--------"+System.currentTimeMillis();
        con.setRequestProperty("Content-Type","multipart/form-data;boundary=" + BOUNDARRY);

        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARRY);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
        sb.append("Content-Type:application/octet-stream\r\n\r\n");

        byte[] head = sb.toString().getBytes("utf-8");

        //获得输出流
        OutputStream out = new DataOutputStream(con.getOutputStream());
        //输出表头
        out.write(head);

        //文件正文部分
        //把文件以流的方式推入到url中
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while((bytes = in.read(bufferOut))!= -1){
            out.write(bufferOut,0,bytes);
        }
        in.close();

        //尾部部分
        byte[] foot = ("\r\n--" + BOUNDARRY + "--\r\n").getBytes("utf-8");//定义数据最后分割线

        out.write(foot);

        out.flush();
        out.close();

        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        String result = null;
        try{
            //定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while((line = reader.readLine()) != null){
                buffer.append(line);
            }
            if(result == null)
                result =  buffer.toString();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null )
                reader.close();
        }

        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
        System.out.println(jsonObject);
        String typeName = "media_id";
        if(!"image".equals(type)){
            typeName = type + "_media_id";
        }
        String mediaId = jsonObject.get(typeName).getAsString();
        return mediaId;
    }
}
