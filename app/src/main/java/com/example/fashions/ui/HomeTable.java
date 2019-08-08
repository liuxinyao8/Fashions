package com.example.fashions.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.fashions.R;
import com.example.fashions.adapter.home.HomeTabAdapter;
import com.example.fashions.base.BaseMActivity;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.interfaces.news.HomeTabContract;
import com.example.fashions.model.bean.HomeTableBean;
import com.example.fashions.persenter.homepresneter.HomeTabPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTable extends BaseMActivity implements HomeTabContract.view {


    @BindView(R.id.tab_home)
    TabLayout tabHome;
    @BindView(R.id.tv1_hometab)
    TextView tv1Hometab;
    @BindView(R.id.rv_hometal)
    RecyclerView rvHometal;
    @BindView(R.id.tb_homtabl)
    Toolbar tbHomtabl;
    private ArrayList<HomeTableBean.DataBeanX.FilterCategoryBean> filterCategoryBeans;
    private ArrayList<HomeTableBean.DataBeanX.GoodsListBean> goodsListBeans;
    private HomeTabAdapter homeTabAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_table;
    }

    @Override
    protected void initView() {
        setSupportActionBar(tbHomtabl);
        filterCategoryBeans = new ArrayList<>();
        goodsListBeans = new ArrayList<>();
        homeTabAdapter = new HomeTabAdapter(goodsListBeans, context);
        rvHometal.setAdapter(homeTabAdapter);
        rvHometal.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected void initData() {
        ((HomeTabPresenter) persenter).getHomeTableP();
    }

    @Override
    protected IPersenter createPersenter() {
        return new HomeTabPresenter();
    }

    @Override
    public void getHomeTable(HomeTableBean homeTableBean) {
        filterCategoryBeans.addAll(homeTableBean.getData().getFilterCategory());
        for (int i = 0; i < filterCategoryBeans.size(); i++) {
            String name = homeTableBean.getData().getFilterCategory().get(i).getName();
            tabHome.addTab(tabHome.newTab().setText(name));
            tv1Hometab.setText(name);
        }
        goodsListBeans.addAll(homeTableBean.getData().getGoodsList());
        homeTabAdapter.notifyDataSetChanged();
    }


}
