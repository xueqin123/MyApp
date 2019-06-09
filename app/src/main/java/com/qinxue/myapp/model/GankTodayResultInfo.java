package com.qinxue.myapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GankTodayResultInfo {
    private List<GankItemInfo> Android;
    private List<GankItemInfo> App;
    private List<GankItemInfo> iOS;
    //休息视频
    @SerializedName("休息视频")
    private List<GankItemInfo> videos;
    //前端
    @SerializedName("前端")
    private List<GankItemInfo> web;
    //    拓展资源
    @SerializedName("拓展资源")
    private List<GankItemInfo> exend;
    //    瞎推荐
    @SerializedName("瞎推荐")
    private List<GankItemInfo> ecommend;
    // 福利
    @SerializedName("福利")
    private List<GankItemInfo> welfare;

}
