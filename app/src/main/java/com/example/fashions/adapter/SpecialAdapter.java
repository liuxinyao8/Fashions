package com.example.fashions.adapter;

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
import com.example.fashions.model.bean.SpecialBean;

import java.util.List;

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.ViewHolder> {
    private List<SpecialBean.DataBeanX.DataBean> data;
    private Context context;

    public SpecialAdapter(List<SpecialBean.DataBeanX.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhuanlan_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final SpecialBean.DataBeanX.DataBean dataBean = data.get(position);
        ((ViewHolder)holder).tv1.setText(dataBean.getTitle());
        ((ViewHolder)holder).tv2.setText(dataBean.getSubtitle());
        ((ViewHolder)holder).tv3.setText(dataBean.getPrice_info()+"元起");
        Glide.with(context).load(dataBean.getScene_pic_url()).into(((ViewHolder)holder).im1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = dataBean.getId();
//                Intent intent = new Intent(context, ZhuanLanActivity.class);
//                intent.putExtra("id",id);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im1;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im1 = itemView.findViewById(R.id.im_special);
            tv1 = itemView.findViewById(R.id.tv1_special);
            tv2 = itemView.findViewById(R.id.tv2_special);
            tv3 = itemView.findViewById(R.id.tv3_special);
        }
    }

}
