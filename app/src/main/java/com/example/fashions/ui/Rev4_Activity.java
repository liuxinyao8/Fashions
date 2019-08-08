package com.example.fashions.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rev4_Activity extends BaseActivity {


    @BindView(R.id.tabl2)
    Toolbar tabl2;
    @BindView(R.id.imag)
    ImageView imag;

    @Override
    protected int getLayout() {
        return R.layout.activity_rev4;
    }

    @Override
    protected void initView() {
        String s = getIntent().getStringExtra("img");
        s.replace("><", "--分割--");
        s.replace(">", "");
        s.replace("<", "");
        String[] split = s.split("--分割--");
        for (int i = 0; i < split.length; i++) {
            String replace = split[i].replace("//", "http://");
            String replace1 = replace.replace("img src=", "");
            split[i] = replace1;
            Log.e("========", split[i]);
            Glide.with(this).load(split[i]).into(imag);
        }
        tabl2.setTitle("仿网易严选");
        setSupportActionBar(tabl2);

    }

}
