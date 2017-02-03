package com.example.wangjiawei.simplesharedpref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wangjiawei.simplesharedpref.libs.SimpleSharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleSharedPref.getService().sample().put("123");
    }
}
