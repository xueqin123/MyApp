package com.qinxue.myapp.model;

/**
 * Copyright 2019 bejson.com
 */


/**
 * Auto-generated: 2019-06-08 21:19:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class XDCategoryItemInfo {

    private String _id;
    private String en_name;
    private String name;
    private int rank;
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_id() {
        return _id;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }
    public String getEn_name() {
        return en_name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "XDCategoryItemInfo{" +
                "_id='" + _id + '\'' +
                ", en_name='" + en_name + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
