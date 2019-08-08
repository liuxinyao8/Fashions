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
import com.example.fashions.ui.Rev4_Activity;

import java.util.List;

public class HomeAdapter4 extends RecyclerView.Adapter<HomeAdapter4.ViewHolder> {
    private List<IndexBean.DataBean.TopicListBean> topicList;
    private Context context;

    public HomeAdapter4(List<IndexBean.DataBean.TopicListBean> topicList, Context context) {
        this.topicList = topicList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item4, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final IndexBean.DataBean.TopicListBean topicListBean = topicList.get(i);
        viewHolder.tv1.setText(topicListBean.getTitle());
        viewHolder.tv2.setText(topicListBean.getSubtitle());
        viewHolder.tv3.setText("￥"+topicListBean.getPrice_info()+"元起");
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(viewHolder.home_rv4_im1);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Rev4_Activity.class);
                intent.putExtra("img",topicListBean.getContent());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView home_rv4_im1;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_rv4_im1=itemView.findViewById(R.id.home_rv4_im);
            tv1=itemView.findViewById(R.id.home_rv4_tv1);
            tv2=itemView.findViewById(R.id.home_rv4_tv2);
            tv3=itemView.findViewById(R.id.home_rv4_tv3);
        }
    }


}
