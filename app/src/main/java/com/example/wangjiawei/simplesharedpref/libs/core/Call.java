package com.example.wangjiawei.simplesharedpref.libs.core;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public interface Call<T> {

    T get();

    void put(T t);

    Call<T> setKey(String key);
}