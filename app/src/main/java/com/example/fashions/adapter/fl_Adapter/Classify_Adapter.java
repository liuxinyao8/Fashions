package com.example.fashions.adapter.fl_Adapter;

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
import com.example.fashions.model.bean.Classify;
import com.example.fashions.model.bean.Classify_RecyBean;

import java.util.List;

public class Classify_Adapter extends RecyclerView.Adapter<Classify_Adapter.ViewHolder> {
    private List<Classify_RecyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList;
    private Context context;

    public Classify_Adapter(List<Classify_RecyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList, Context context) {
        this.subCategoryList = subCategoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fl_rv_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Classify_RecyBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = subCategoryList.get(i);
        viewHolder.tv.setText(subCategoryListBean.getName());
        Glide.with(context).load(subCategoryListBean.getWap_banner_url()).into(viewHolder.im);
    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.fl_rv_img1);
            tv=itemView.findViewById(R.id.fl_rv_tv1);
        }
    }
}
