package com.example.wangjiawei.simplesharedpref.libs.core;

import com.example.wangjiawei.simplesharedpref.libs.config.DEFAULT;
import com.example.wangjiawei.simplesharedpref.libs.config.KEY;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class ServiceMethod<T> {

    ServiceMethod(Builder<T> builder) {

    }

    public static final class Builder<T> {
        final Method method;
        final Annotation[] methodAnnotations;

        String mKey;
        String mDefault;

        public Builder(Method method) {
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
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
            }
        }
    }
}
