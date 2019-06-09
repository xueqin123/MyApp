package com.qinxue.myapp.model;

public class GankResult<T> {
    boolean error;
    T results;

    public boolean isError() {
        return error;
    }

    public T getResults() {
        return results;
    }

}
