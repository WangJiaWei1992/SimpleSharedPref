package com.example.wangjiawei.simplesharedpref.libs.core;

import com.example.wangjiawei.simplesharedpref.libs.config.DEFAULT;
import com.example.wangjiawei.simplesharedpref.libs.config.KEY;
import com.example.wangjiawei.simplesharedpref.libs.config.SYNC;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class ServiceMethod<T> {

    private String mKey;
    private String mDefault;
    private boolean mIsSync;
    private final Class mTypeClass;

    ServiceMethod(Builder<T> builder) {
        mKey = builder.mKey;
        mDefault = builder.mDefault;
        mTypeClass = builder.mTypeClass;
        mIsSync = builder.mIsSync;
    }

    public String getKey() {
        return mKey;
    }

    public String getDefault() {
        return mDefault;
    }

    public boolean isSync() {
        return mIsSync;
    }

    public Class getTypeClass() {
        return mTypeClass;
    }

    public static final class Builder<T> {
        final Method method;
        final Annotation[] methodAnnotations;

        String mKey;
        String mDefault;
        boolean mIsSync;
        final Class mTypeClass;

        public Builder(Method method) {
            this.method = method;
            this.methodAnnotations = method.getAnnotations();

            ParameterizedType returnType = (ParameterizedType) method.getGenericReturnType();
            Type[] types = returnType.getActualTypeArguments();
            mTypeClass = (Class) types[0];
        }

        public ServiceMethod build() {
            for (Annotation annotation : methodAnnotations) {
                parseMethodAnnotation(annotation);
            }

            return new ServiceMethod<>(this);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof KEY) {
                mKey = ((KEY) annotation).value();
            } else if (annotation instanceof DEFAULT) {
                mDefault = ((DEFAULT) annotation).value();
            } else if (annotation instanceof SYNC) {
                mIsSync = true;
            }
        }

    }
}
