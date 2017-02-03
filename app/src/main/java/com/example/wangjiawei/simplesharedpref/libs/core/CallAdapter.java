package com.example.wangjiawei.simplesharedpref.libs.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public interface CallAdapter<T> {

    Type responseType();

    <R> T adapt(Call<R> call);

    abstract class Factory {

        public abstract CallAdapter<?> get(Type returnType, Annotation[] annotations);
    }
}
