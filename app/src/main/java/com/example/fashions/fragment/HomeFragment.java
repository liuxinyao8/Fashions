package com.example.fashions.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.adapter.home.HomeAdapter;
import com.example.fashions.adapter.home.HomeAdapter2;
import com.example.fashions.adapter.home.HomeAdapter3;
import com.example.fashions.adapter.home.HomeAdapter4;
import com.example.fashions.adapter.home.HomeAdapter5;
import com.example.fashions.base.BaseFragment;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.interfaces.news.NewsContract;
import com.example.fashions.model.bean.IndexBean;
import com.example.fashions.persenter.homepresneter.MyPersenter;
import com.example.fashions.ui.HomeTable;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements NewsContract.View {

    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    @BindView(R.id.home_rv2)
    RecyclerView homeRv2;
    @BindView(R.id.home_rv3)
    RecyclerView homeRv3;
    @BindView(R.id.home_rv4)
    RecyclerView homeRv4;
    @BindView(R.id.home_rv5)
    RecyclerView homeRv5;
    @BindView(R.id.home_table)
    TabLayout homeTable;
    private ArrayList<IndexBean.DataBean.BannerBean> bannerBeans;
    private ArrayList<IndexBean.DataBean.CategoryListBean> categoryListBeans;
    private ArrayList<IndexBean.DataBean.BrandListBean> brandListBeans;
    private ArrayList<IndexBean.DataBean.ChannelBean> channelBeans;
    private HomeAdapter brandAdapter;
    private ArrayList<IndexBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private HomeAdapter2 homeAdapter2;
    private ArrayList<IndexBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private HomeAdapter3 homeAdapter3;
    private ArrayList<IndexBean.DataBean.TopicListBean> topicListBeans;
    private HomeAdapter4 homeAdapter4;
    private HomeAdapter5 homeAdapter5;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(Bundle bundle) {
        bannerBeans = new ArrayList<>();//banner
        channelBeans = new ArrayList<>();//tv行
        brandListBeans = new ArrayList<>();//品牌制造商
        brandAdapter = new HomeAdapter(brandListBeans, getActivity());
        homeRv.setAdapter(brandAdapter);
        homeRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        newGoodsListBeans = new ArrayList<>();//周一周四
        homeAdapter2 = new HomeAdapter2(newGoodsListBeans, getActivity());
        homeRv2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        homeRv2.setAdapter(homeAdapter2);

        //人气推荐
        hotGoodsListBeans = new ArrayList<>();
        homeRv3.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapter3 = new HomeAdapter3(hotGoodsListBeans, getActivity());
        homeRv3.setAdapter(homeAdapter3);

        //专栏
        topicListBeans = new ArrayList<>();
        homeAdapter4 = new HomeAdapter4(topicListBeans, getActivity());
        homeRv4.setAdapter(homeAdapter4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeRv4.setLayoutManager(linearLayoutManager);

        //居家
        categoryListBeans = new ArrayList<>();
        homeAdapter5 = new HomeAdapter5(categoryListBeans, getActivity());
        homeRv5.setAdapter(homeAdapter5);
        homeRv5.setLayoutManager(new LinearLayoutManager(getActivity()));

       homeTable.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               startActivity(new Intent(getActivity(),HomeTable.class));
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
    }



    @Override
    protected void initData() {
        ((MyPersenter) persenter).getIndex();
    }

    @Override
    protected IPersenter createPersenter() {
        return new MyPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void getIndexReturn(IndexBean indexBean) {
        if (indexBean != null) {
            //品牌制造商
            brandListBeans.addAll(indexBean.getData().getBrandList());
            brandAdapter.notifyDataSetChanged();
            //周一周四
            newGoodsListBeans.addAll(indexBean.getData().getNewGoodsList());
            homeAdapter2.notifyDataSetChanged();

            //人气推荐
            List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList = indexBean.getData().getHotGoodsList();
            hotGoodsListBeans.addAll(hotGoodsList);
            homeAdapter3.notifyDataSetChanged();


            channelBeans.addAll(indexBean.getData().getChannel());

            //banner
            bannerBeans.addAll(indexBean.getData().getBanner());
            homeBanner.setImages(bannerBeans).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    IndexBean.DataBean.BannerBean bannerBean = (IndexBean.DataBean.BannerBean) path;
                    Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
                }
            }).start();

            //tv行
            for (int i = 0; i < channelBeans.size(); i++) {
                homeTable.setSelectedTabIndicatorHeight(0);
                homeTable.addTab(homeTable.newTab().setText(indexBean.getData().getChannel().get(i).getName()));
            }
            //专栏
            topicListBeans.addAll(indexBean.getData().getTopicList());
            homeAdapter4.notifyDataSetChanged();

            //居家
            categoryListBeans.addAll(indexBean.getData().getCategoryList());
            homeAdapter5.notifyDataSetChanged();
        }

    }
}
