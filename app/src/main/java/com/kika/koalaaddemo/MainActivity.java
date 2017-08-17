package com.kika.koalaaddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kika.pluto.appwall.KoalaAppWallActivity;
import com.kika.pluto.controller.KoalaADAgent;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mNativeAdBtn;
    private Button mAppWallBtn;
    private Button mAboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Koala Ad SDK here
        KoalaADAgent.init(getApplicationContext());

        initView();
    }

    private void initView(){
        mNativeAdBtn = (Button) findViewById(R.id.native_ad_btn);
        mAboutBtn = (Button) findViewById(R.id.about_btn);
        mAppWallBtn = (Button) findViewById(R.id.appwall_btn);

        mNativeAdBtn.setOnClickListener(this);
        mAboutBtn.setOnClickListener(this);
        mAppWallBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.native_ad_btn:
                intent = new Intent(MainActivity.this, NativeAdActivity.class);
                startActivity(intent);
                break;
            case R.id.about_btn:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.appwall_btn:
                intent = new Intent(MainActivity.this, KoalaAppWallActivity.class);
                startActivity(intent);
                break;
        }
    }
}
