package com.qf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qf.day32_eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Ken on 2016/9/28.11:02
 */
public class MyFragment2 extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, null);
        tv = (TextView) view.findViewById(R.id.tv);
        EventBus.getDefault().register(this);
        return view;
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 1000)
    public void onFragmentEvent(MyFragment.Student str){
//        tv.setText(str + "");
        tv.setText(str.address+ str.age);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
