package com.example.fashions.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.adapter.homerv3_detail.HomeR2Detail;
import com.example.fashions.base.BaseMActivity;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.interfaces.news.HomeRv3Contract;
import com.example.fashions.model.bean.HomeRv2Bean;
import com.example.fashions.persenter.homepresneter.HomeRv3Presneter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Homerv2 extends BaseMActivity implements HomeRv3Contract.view {


    @BindView(R.id.home_rv3detail_ban)
    Banner homeRv3detailBan;
    @BindView(R.id.home_rv3tv_detail)
    TextView homeRv3tvDetail;
    @BindView(R.id.home_rv3tv2_detail)
    TextView homeRv3tv2Detail;
    @BindView(R.id.home_rv3tv3_detail)
    TextView homeRv3tv3Detail;
    @BindView(R.id.home_rv3tv4_detail)
    TextView homeRv3tv4Detail;
    @BindView(R.id.home_rv3_rvdetail)
    RecyclerView homeRv3Rvdetail;
    private int id;
    private ArrayList<String> infoBeans;
    private ArrayList<HomeRv2Bean.DataBeanX.IssueBean> issueBeans;
    private HomeR2Detail homeRv3_detail;

    @Override
    protected int getLayout() {
        return R.layout.activity_homerv3;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("rv3id", 0);
        issueBeans = new ArrayList<>();
        homeRv3Rvdetail.setLayoutManager(new LinearLayoutManager(this));
        homeRv3_detail = new HomeR2Detail(issueBeans, this);
        homeRv3Rvdetail.setAdapter(homeRv3_detail);
    }

    @Override
    protected void initData() {
        ((HomeRv3Presneter) persenter).getRv3p(id);
    }

    @Override
    protected IPersenter createPersenter() {
        return new HomeRv3Presneter();
    }

    @Override
    public void getRv3(HomeRv2Bean homeRv3Bean) {
        infoBeans = new ArrayList<>();
        infoBeans.add(homeRv3Bean.getData().getInfo().getPrimary_pic_url());
        infoBeans.add(homeRv3Bean.getData().getInfo().getList_pic_url());
        homeRv3detailBan.setImages(infoBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        homeRv3tvDetail.setText(homeRv3Bean.getData().getInfo().getName());
        homeRv3tv2Detail.setText(homeRv3Bean.getData().getInfo().getGoods_brief());
        homeRv3tv3Detail.setText("￥"+homeRv3Bean.getData().getInfo().getRetail_price());

        List<HomeRv2Bean.DataBeanX.IssueBean> issue = homeRv3Bean.getData().getIssue();
        issueBeans.addAll(issue);
        homeRv3_detail.notifyDataSetChanged();
    }

}
