package com.example.wangjiawei.simplesharedpref.libs;

import com.example.wangjiawei.simplesharedpref.libs.core.Call;
import com.example.wangjiawei.simplesharedpref.libs.config.DEFAULT;
import com.example.wangjiawei.simplesharedpref.libs.config.KEY;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public interface ISharedPref {

    @KEY("sample")
    @DEFAULT("default")
    Call<String> sample();
}
