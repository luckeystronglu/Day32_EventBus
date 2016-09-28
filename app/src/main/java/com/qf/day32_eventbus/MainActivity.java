package com.qf.day32_eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        tv = (TextView) findViewById(R.id.tv);
    }

    //定义一个接收EventBus的方法
    @Subscribe
    public void onEvent(String value){
        tv.setText(value);
    }




    @Override
    protected void onStop() {
        super.onStop();
        //注销EventBus
        EventBus.getDefault().unregister(this);
    }
}
