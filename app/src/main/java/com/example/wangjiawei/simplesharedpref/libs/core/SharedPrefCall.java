package com.example.wangjiawei.simplesharedpref.libs.core;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class SharedPrefCall<T> implements Call<T>  {

    private final ServiceMethod<T> serviceMethod;
    private final Object[] args;

    public SharedPrefCall(ServiceMethod<T> serviceMethod, Object[] args) {
        this.serviceMethod = serviceMethod;
        this.args = args;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public void put(T t) {

    }
}
