package com.example.fashions.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fashions.R;
import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.utils.SystemUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseMActivity<V extends IBaseView,P extends IPersenter> extends AppCompatActivity implements IBaseView {

    protected Context context;
    protected P persenter;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        bind = ButterKnife.bind(this);
        if(!SystemUtils.checkNetWork()){
            //自定义布局实现无网络状态的提示
            View view = LayoutInflater.from(this).inflate(R.layout.layout_network_error,null);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addContentView(view,params);
        }else{
            context = this;
            initView();
            persenter = createPersenter();
            initData();
        }
    }

    //获取布局
    protected abstract int getLayout();

    //初始化布局
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //创建P
    protected abstract P createPersenter();

    @Override
    protected void onResume() {
        super.onResume();
        if(persenter != null){
            persenter.attchView(this);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(bind!=null){
            bind.unbind();
        }
    }
}
