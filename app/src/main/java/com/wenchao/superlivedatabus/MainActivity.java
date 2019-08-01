package com.wenchao.superlivedatabus;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //订阅一个消息 订阅者
//        LiveDataBus.getInstance().with("李三", HuaWei.class).observe(this,
//                new Observer<HuaWei>() {
//
//                    @Override
//                    public void onChanged(@Nullable HuaWei huaWei) {
//                        Toast.makeText(MainActivity.this, huaWei.getName() + "," + huaWei.getType(), Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

    public void sendMessage(View view) {
        //发布消息
        HuaWei huaWei = new HuaWei("华为", "Mate-30");
        LiveDataBus.getInstance().with("李三", HuaWei.class).postValue(huaWei);
    }

    public void jumpActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TwoActivity.class);
        startActivity(intent);
        finish();
    }
}
