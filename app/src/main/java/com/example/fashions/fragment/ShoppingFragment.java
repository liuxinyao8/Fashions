package com.example.fashions.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fashions.R;
import com.example.fashions.base.BaseFragment;
import com.example.fashions.interfaces.IPersenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends BaseFragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopping;
    }

}
