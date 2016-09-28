package com.qf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qf.day32_eventbus.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Ken on 2016/9/28.11:02
 */
public class MyFragment extends Fragment implements View.OnClickListener {

    private Button button;

    private int i;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, null);
        button = (Button) view.findViewById(R.id.btn);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //在需要发送的地方进行消息发送
//        EventBus.getDefault().post("这是Fragemnt发送的消息");
//        EventBus.getDefault().post(10);

        new Thread(){
            @Override
            public void run() {
                while (true) {
//                    EventBus.getDefault().post(i++);
                    EventBus.getDefault().post(new Student());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    class Student{
        int age = 30;
        String address = "深圳";
    }
}
