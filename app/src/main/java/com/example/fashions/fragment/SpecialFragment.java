package com.example.fashions.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fashions.R;
import com.example.fashions.adapter.SpecialAdapter;
import com.example.fashions.base.BaseFragment;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.interfaces.Specia.SpeciaContract;
import com.example.fashions.model.bean.SpecialBean;
import com.example.fashions.persenter.Specialpresenter.SpecialPresneter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends BaseFragment implements SpeciaContract.View {


    @BindView(R.id.special_rv)
    RecyclerView specialRv;
    private ArrayList<SpecialBean.DataBeanX.DataBean> dataBeans;
    private SpecialAdapter specialAdapter;

    public SpecialFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView(Bundle bundle) {
    specialRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        specialAdapter = new SpecialAdapter(dataBeans, getActivity());
        specialRv.setAdapter(specialAdapter);
    }

    @Override
    protected void initData() {
        ((SpecialPresneter) persenter).getZhuangLan();
    }

    @Override
    protected IPersenter createPersenter() {
        return new SpecialPresneter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_special;
    }

    @Override
    public void getzhaunglan1(SpecialBean specialBean) {
        List<SpecialBean.DataBeanX.DataBean> data = specialBean.getData().getData();
        dataBeans.addAll(data);
        specialAdapter.notifyDataSetChanged();
    }


}
