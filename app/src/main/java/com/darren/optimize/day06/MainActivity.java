package com.darren.optimize.day06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setOnClickListener(this);

        NativeCrashMonitor nativeCrashMonitor = new NativeCrashMonitor();
        nativeCrashMonitor.init(new CrashHandlerListener() {
            @Override
            public void onCrash(String threadName, Error error) {

            }
        });

        // 没有修改系统底层源码的情况下，各大厂商可能有点点不一样
        // 会不会引起 ANR ， 1，2
        // 会 1
        /*try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 会不会引起 ANR ， 1，2
        // 不会
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        // 没有修改系统底层源码的情况下，各大厂商可能有点点不一样
        // 点击会不会 ANR 1， 2
        // 第一次点击不会 2
        // 连续多次点击会 1
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // NativeCrashMonitor.nativeCrash();
        // 面试：社招 20-30
        // 校招：国内国外是 Top40
    }
}
