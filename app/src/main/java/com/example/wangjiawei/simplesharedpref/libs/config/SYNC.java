package com.example.wangjiawei.simplesharedpref.libs.config;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by WangJiaWei on 2017/5/2.
 */

@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface SYNC {
}