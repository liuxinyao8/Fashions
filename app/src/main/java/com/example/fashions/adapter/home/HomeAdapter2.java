package com.example.fashions.adapter.home;

import android.content.Context;
import android.content.Intent;
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
import com.example.fashions.ui.Homerv2;

import java.util.List;

public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.ViewHolder> {
    private List<IndexBean.DataBean.NewGoodsListBean> newGoodsList;
    private Context context;

    public HomeAdapter2(List<IndexBean.DataBean.NewGoodsListBean> newGoodsList, Context context) {
        this.newGoodsList = newGoodsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item2, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final IndexBean.DataBean.NewGoodsListBean newGoodsListBean = newGoodsList.get(i);
        viewHolder.tv1.setText(newGoodsListBean.getName());
        viewHolder.tv2.setText("￥"+newGoodsListBean.getRetail_price());
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(viewHolder.home_rv2_im);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = newGoodsListBean.getId();
                Intent intent = new Intent(context, Homerv2.class);
                intent.putExtra("rv3id",id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newGoodsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView home_rv2_im;
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_rv2_im=itemView.findViewById(R.id.home_rv2_im);
            tv1=itemView.findViewById(R.id.home_rv2_tv1);
            tv2=itemView.findViewById(R.id.home_rv2_tv2);
        }
    }
}
