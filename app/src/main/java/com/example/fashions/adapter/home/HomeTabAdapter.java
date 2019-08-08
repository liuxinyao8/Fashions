package com.example.fashions.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.model.bean.HomeTableBean;

import java.util.List;

public class HomeTabAdapter extends RecyclerView.Adapter<HomeTabAdapter.ViewHolder> {
    private List<HomeTableBean.DataBeanX.GoodsListBean> goodsList;
    private Context context;

    public HomeTabAdapter(List<HomeTableBean.DataBeanX.GoodsListBean> goodsList, Context context) {
        this.goodsList = goodsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hometab, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HomeTableBean.DataBeanX.GoodsListBean goodsListBean = goodsList.get(i);
        viewHolder.tv.setText(goodsListBean.getName());
        viewHolder.tv2.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(viewHolder.im);

    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv;
        private TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.home_tab_im);
            tv = itemView.findViewById(R.id.home_tab_tv2);
            tv2 = itemView.findViewById(R.id.home_tab_tv3);
        }
    }
}
