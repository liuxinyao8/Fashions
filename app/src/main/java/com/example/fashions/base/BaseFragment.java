package com.example.fashions.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;

import butterknife.ButterKnife;

public abstract class BaseFragment<V extends IBaseView,P extends IPersenter> extends Fragment implements IBaseView {
    protected Context context;
    protected P persenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View inflate = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, inflate);
        initView(bundle);
        persenter = createPersenter();
        if (persenter != null) {
            persenter.attchView(this);
        }
        initData();
        return inflate;
    }

    protected abstract void initView(Bundle bundle);

    protected abstract void initData();

    protected abstract P createPersenter();

    protected abstract int getLayoutId();

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
    @Override
    public void onResume() {
        super.onResume();
        if (persenter != null) {
            persenter.attchView(this);
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (persenter != null) {
            persenter.detachView();
        }
    }
}
