package com.example.wangjiawei.simplesharedpref.libs;

import com.example.wangjiawei.simplesharedpref.libs.core.Call;
import com.example.wangjiawei.simplesharedpref.libs.config.DEFAULT;
import com.example.wangjiawei.simplesharedpref.libs.config.KEY;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public interface ISharedPref {

    @KEY("sample")
    @DEFAULT("10")
    Call<Integer> sample();

    @KEY("sample1")
    @DEFAULT("sample1")
    Call<String> sample1();

    @KEY("sample2")
    @DEFAULT("10.5")
    Call<Float> sample2();

    @KEY("sample3")
    @DEFAULT("true")
    Call<Boolean> sample3();

    @KEY("sample4")
    @DEFAULT("13256516585156")
    Call<Long> sample4();

    @KEY("device_name_")
    @DEFAULT("")
    Call<String> sample5();
}
