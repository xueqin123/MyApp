package com.qinxue.myapp.net.clients.gank.factorys;

import com.qinxue.myapp.model.GankResult;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GankResultType implements ParameterizedType {
    private Type type;

    public GankResultType(Type type) {
        this.type = type;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{type};
    }

    @Override
    public Type getRawType() {
        return GankResult.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
