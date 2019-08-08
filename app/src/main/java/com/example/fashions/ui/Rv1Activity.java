package com.example.fashions.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rv1Activity extends BaseActivity {

    @BindView(R.id.wv_rv1_im)
    ImageView wvRv1Im;
    @BindView(R.id.wv_rv1_tv)
    TextView wvRv1Tv;
    @BindView(R.id.tabll)
    Toolbar tabll;

    @Override
    protected int getLayout() {
        return R.layout.activity_rv1;
    }

    @Override
    protected void initView() {
        tabll.setTitle("仿网易严选");
        setSupportActionBar(tabll);
        Intent intent = getIntent();
        String url = intent.getStringExtra("im");
        String desc = intent.getStringExtra("desc");
        Log.e("url", url);
        Log.e("desc", desc);
        Glide.with(this).load(url).into(wvRv1Im);
        wvRv1Tv.setText(desc);
    }
}
