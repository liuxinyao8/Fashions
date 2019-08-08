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
import com.example.fashions.model.bean.IndexBean;

import java.util.List;

public class HomeAdapter5_2 extends RecyclerView.Adapter<HomeAdapter5_2.ViewHolder> {
    private List<IndexBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    private Context context;

    public HomeAdapter5_2(List<IndexBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans, Context context) {
        this.goodsListBeans = goodsListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item5_22, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        IndexBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsListBeans.get(i);
        viewHolder.tv1.setText(goodsListBeans.get(i).getName());
        viewHolder.tv2.setText("￥"+goodsListBeans.get(i).getRetail_price());
        Glide.with(context).load(goodsListBeans.get(i).getList_pic_url()).into(viewHolder.im);
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.home_rv5_im);
            tv1=itemView.findViewById(R.id.home_rv5_tv2);
            tv2=itemView.findViewById(R.id.home_rv5_tv3);
        }
    }
}
