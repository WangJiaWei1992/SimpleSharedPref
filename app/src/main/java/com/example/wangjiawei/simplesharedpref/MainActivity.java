package com.example.wangjiawei.simplesharedpref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wangjiawei.simplesharedpref.libs.SimpleSharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleSharedPref.getService().sample().put(10);
        int r = SimpleSharedPref.getService().sample().get();

        SimpleSharedPref.getService().sample1().put("hehe");
        String r1 = SimpleSharedPref.getService().sample1().get();

        SimpleSharedPref.getService().sample2().put(10.123f);
        float r2 = SimpleSharedPref.getService().sample2().get();

        SimpleSharedPref.getService().sample3().put(false);
        boolean r3 = SimpleSharedPref.getService().sample3().get();

        SimpleSharedPref.getService().sample4().put(55555555555555L);
        long r4 = SimpleSharedPref.getService().sample4().get();

        SimpleSharedPref.getService().sample5().setKey("haha").put("123");
    }
}
