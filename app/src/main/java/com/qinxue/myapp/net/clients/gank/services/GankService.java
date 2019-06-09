package com.qinxue.myapp.net.clients.gank.services;


import android.arch.lifecycle.LiveData;

import com.qinxue.myapp.model.GankResult;
import com.qinxue.myapp.model.XDCategoryItemInfo;
import com.qinxue.myapp.net.clients.gank.factorys.ApiResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface GankService {
    //    获取最新一天的干货
//    例如： http://gank.io/api/today
    @GET("today")
    LiveData<ResponseBody> getToday();

    @GET("xiandu/categories")
    LiveData<ApiResponse<GankResult<List<XDCategoryItemInfo>>>> getXDCategorys();
}
