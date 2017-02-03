package com.example.wangjiawei.simplesharedpref.libs.core;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class ExecutorCallbackCall<T> implements Call<T> {

    final Call<T> delegate;

    public ExecutorCallbackCall(Call<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T get() {
        return delegate.get();
    }

    @Override
    public void put(T t) {
        delegate.put(t);
    }
}
