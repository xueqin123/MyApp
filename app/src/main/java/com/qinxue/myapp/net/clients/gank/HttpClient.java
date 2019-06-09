package com.qinxue.myapp.net.clients.gank;

import com.qinxue.myapp.net.clients.gank.factorys.GsonConverterFactory;
import com.qinxue.myapp.net.clients.gank.factorys.LiveDataCallAdapterFactory;
import com.qinxue.myapp.net.clients.gank.services.GankService;

import retrofit2.Retrofit;

public class HttpClient {
    private static volatile HttpClient instance;
    private static final String GANK_BASE_URL = "https://gank.io/api/";
    private GankService gankService;

    private HttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .baseUrl(GANK_BASE_URL)
                .build();
        gankService = retrofit.create(GankService.class);
    }

    public static HttpClient getInstance() {
        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new HttpClient();
                }
            }
        }
        return instance;
    }

    public GankService getGankService() {
        return gankService;
    }
}
