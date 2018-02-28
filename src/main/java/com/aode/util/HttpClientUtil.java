//package com.aode.util;
//
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URLDecoder;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by moutian on 2017/6/27 0027.
// */
//
//public class HttpClientUtil {
//    private static Logger logger = LogManager.getLogger(com.tools.utils.HttpClientUtil.class);
//    private static int timeout = 10000;
//
//    public HttpClientUtil() {
//    }
//
//    public static String httpGet(String url, Map<String, String> map) throws Exception {
//        CloseableHttpClient httpclient = HttpClients.custom().build();
//        StringBuilder param = new StringBuilder();
//        BufferedReader bufferedReader = null;
//        InputStream in = null;
//        Iterator response = map.keySet().iterator();
//
//        while(response.hasNext()) {
//            String httpGet = (String)response.next();
//            param.append(httpGet).append("=").append((String)map.get(httpGet)).append("&");
//        }
//
//        url = url + "?" + param.substring(0, param.length() - 1);
//        HttpGet httpGet1 = new HttpGet(url);
//        httpGet1.setConfig(RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build());
//        CloseableHttpResponse response1 = httpclient.execute(httpGet1);
//        String result = null;
//
//        try {
//            if(response1.getStatusLine().getStatusCode() == 200) {
//                HttpEntity ex = response1.getEntity();
//                in = ex.getContent();
//                StringBuilder stringBuilder = new StringBuilder();
//                bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//
//                while((result = bufferedReader.readLine()) != null) {
//                    stringBuilder.append(result);
//                }
//
//                result = stringBuilder.toString();
//            } else {
//                logger.error("get请求提交失败:" + url);
//            }
//        } catch (Exception var14) {
//            url = URLDecoder.decode(url, "UTF-8");
//            logger.error("=====httpGet链接失败url=" + url);
//        } finally {
//            if(httpGet1 != null) {
//                httpGet1.abort();
//            }
//
//            if(httpclient != null) {
//                httpclient.close();
//            }
//
//            if(in != null) {
//                in.close();
//            }
//
//            if(bufferedReader != null) {
//                bufferedReader.close();
//            }
//
//        }
//
//        return result;
//    }
//
//    public static String httpPost(String url, Map<String, String> map) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        String result = null;
//
//        try {
//            httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(timeout).build());
//            ArrayList ex = new ArrayList();
//            Iterator entity = map.keySet().iterator();
//
//            while(entity.hasNext()) {
//                String response = (String)entity.next();
//                ex.add(new BasicNameValuePair(response, (String)map.get(response)));
//            }
//
//            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
//            httpPost.setEntity(new UrlEncodedFormEntity(ex, "UTF-8"));
//            logger.info("===================httpPost=====================url" + url);
//            CloseableHttpResponse response1 = httpClient.execute(httpPost);
//            HttpEntity entity1 = response1.getEntity();
//            result = EntityUtils.toString(entity1, "UTF-8");
//        } catch (Exception var11) {
//            url = URLDecoder.decode(url, "UTF-8");
//            logger.error(var11.getMessage(), var11);
//        } finally {
//            if(httpPost != null) {
//                httpPost.abort();
//            }
//
//            if(httpClient != null) {
//                httpClient.close();
//            }
//
//        }
//
//        return result;
//    }
//
//    public static InputStream httpGet(String url) throws IOException {
//        CloseableHttpClient httpclient = HttpClients.custom().build();
//        InputStream in = null;
//        HttpGet httpGet = new HttpGet(url);
//        httpGet.setConfig(RequestConfig.custom().setConnectionRequestTimeout(timeout).build());
//        CloseableHttpResponse response = httpclient.execute(httpGet);
//
//        try {
//            if(response.getStatusLine().getStatusCode() == 200) {
//                HttpEntity ex = response.getEntity();
//                in = ex.getContent();
//            } else {
//                logger.error("get请求提交失败:" + url);
//            }
//        } catch (Exception var9) {
//            if(in != null) {
//                in.close();
//            }
//
//            url = URLDecoder.decode(url, "UTF-8");
//            logger.error("=====httpGet链接失败，url=" + url);
//        } finally {
//            if(httpGet != null) {
//                httpGet.abort();
//            }
//
//            if(httpclient != null) {
//                httpclient.close();
//            }
//
//        }
//
//        return in;
//    }
//
//    public static InputStream httpPost(String url) {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        InputStream inputStream = null;
//
//        try {
//            httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(timeout).build());
//            logger.info("===================httpPost=====================url" + url);
//            CloseableHttpResponse ex = httpClient.execute(httpPost);
//            HttpEntity entity = ex.getEntity();
//            inputStream = entity.getContent();
//        } catch (Exception var14) {
//            var14.printStackTrace();
//            logger.error(var14.getMessage(), var14);
//        } finally {
//            if(httpPost != null) {
//                httpPost.abort();
//            }
//
//            if(httpClient != null) {
//                try {
//                    httpClient.close();
//                } catch (IOException var13) {
//                    var13.printStackTrace();
//                }
//            }
//
//        }
//
//        return inputStream;
//    }
//}
