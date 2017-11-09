package com.imooc.ip;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.ip
 * @description: TODO
 * @date 2017/11/9 22:04
 */
public class IpQuery {

    public static void main(String[] args) {
        // 要查询的IP地址
        String ip = "183.220.25.155";
        try {
//			String str = sendGet("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip, "UTF-8");
            String str = sendPost("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip, null, "UTF-8");
            JSONObject json = new JSONObject(str);
            JSONObject data = json.getJSONObject("data");
            System.out.println("国家-->" + data.getString("country"));
            System.out.println("地区-->" + data.getString("area"));
            System.out.println("省份-->" + data.getString("region"));
            System.out.println("城市-->" + data.getString("city"));
            System.out.println("区县-->" + data.getString("county"));
            System.out.println("运营商-->" + data.getString("isp"));
        } catch (Exception e) {
            System.out.println("解析JSON失败，原因：" + e.toString());
        }
    }

    /**
     * 模拟GET请求
     *
     * @param url
     *            资源地址
     * @param encoding
     *            编码
     * @return
     * @throws IOException
     */
    public static String sendGet(String url, String encoding) {
        String body = "";

        // 创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建get方式请求对象
        HttpGet httpGet = new HttpGet(url);
        // 响应结果
        CloseableHttpResponse response = null;
        try {
            // 执行请求操作，并拿到结果（同步阻塞）
            response = client.execute(httpGet);
            // 获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            // 消耗掉response
            EntityUtils.consume(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放链接
                if (response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return body;
    }

    /**
     * 模拟POST请求
     *
     * @param url
     *            资源地址
     * @param map
     *            参数列表
     * @param encoding
     *            编码
     * @return
     */
    public static String sendPost(String url, Map<String, String> map, String encoding) {
        String body = "";

        // 创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 响应结果
        CloseableHttpResponse response = null;
        // 装填参数
        List<NameValuePair> nvps = new ArrayList<>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        try {
            // 设置参数到请求对象中
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

            // 设置header信息
            // 指定报文头【Content-type】、【User-Agent】
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 执行请求操作，并拿到结果（同步阻塞）
            response = client.execute(httpPost);
            // 获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            // 消耗掉response
            EntityUtils.consume(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放链接
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return body;
    }
}
