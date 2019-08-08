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
import com.example.fashions.ui.Rv1Activity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<IndexBean.DataBean.BrandListBean> brandList;
    private Context context;

    public HomeAdapter(List<IndexBean.DataBean.BrandListBean> brandList, Context context) {
        this.brandList = brandList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item1, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final IndexBean.DataBean.BrandListBean brandListBean = brandList.get(i);
        viewHolder.tv1.setText(brandListBean.getName());
        viewHolder.tv2.setText(brandListBean.getFloor_price()+"元起");
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(viewHolder.home_im);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = brandListBean.getList_pic_url();
                String desc = brandListBean.getSimple_desc();
                Intent intent = new Intent(context, Rv1Activity.class);
                intent.putExtra("im",url);
                intent.putExtra("desc",desc);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView home_im;
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_im=itemView.findViewById(R.id.home_rv_im);
            tv1=itemView.findViewById(R.id.home_rv_tv1);
            tv2=itemView.findViewById(R.id.home_rv_tv2);
        }
    }
}
