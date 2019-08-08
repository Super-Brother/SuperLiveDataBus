package com.wenchao.superlivedatabus;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wenchao.livedatabus.LiveDataBus;

/**
 * @author wenchao
 * @date 2019/8/1.
 * @time 22:19
 * description：
 */
public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //订阅一个消息 订阅者
        final MutableLiveData<HuaWei> liveData = LiveDataBus.getInstance().with("李三", HuaWei.class);
        liveData.observe(this, new Observer<HuaWei>() {

            @Override
            public void onChanged(@Nullable HuaWei huaWei) {
                Toast.makeText(TwoActivity.this, huaWei.getName() + "," + huaWei.getType(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendMessage(View view) {
        //发布消息
        HuaWei huaWei = new HuaWei("华为", "Mate-40");
        LiveDataBus.getInstance().with("李三", HuaWei.class).postValue(huaWei);
    }
}
