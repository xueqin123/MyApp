package com.qinxue.myapp.net;


import com.qinxue.myapp.net.clients.gank.HttpClient;

public class HttpClientManger {
    public static HttpClient getGankHttpClient() {
        return HttpClient.getInstance();
    }
}
