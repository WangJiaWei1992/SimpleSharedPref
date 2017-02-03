package com.example.wangjiawei.simplesharedpref;

import android.app.Application;
import android.content.Context;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
