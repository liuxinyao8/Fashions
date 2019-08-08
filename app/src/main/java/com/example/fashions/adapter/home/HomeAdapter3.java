package com.example.fashions.adapter.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.model.bean.IndexBean;

import java.util.List;

public class HomeAdapter3 extends RecyclerView.Adapter<HomeAdapter3.ViewHolder> {
    private List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList;
    private Context context;

    public HomeAdapter3(List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList, Context context) {
        this.hotGoodsList = hotGoodsList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       /* View view = LayoutInflater.from(context).inflate(R.layout.home_item3, null);
        ViewHolder viewHolder = new ViewHolder(view);*/
        View inflate = View.inflate(context, R.layout.home_item3, null);
        return new ViewHolder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final IndexBean.DataBean.HotGoodsListBean hotGoodsListBean = hotGoodsList.get(i);
        viewHolder.tv1.setText(hotGoodsListBean.getName());
        viewHolder.tv2.setText(hotGoodsListBean.getGoods_brief());
        viewHolder.tv3.setText("￥"+hotGoodsListBean.getRetail_price());
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(viewHolder.home_rv3_im1);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return hotGoodsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView home_rv3_im1;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_rv3_im1=itemView.findViewById(R.id.home_rv3_im);
            tv1=itemView.findViewById(R.id.home_rv3_tv1);
            tv2=itemView.findViewById(R.id.home_rv3_tv2);
            tv3=itemView.findViewById(R.id.home_rv3_tv3);
        }
    }
}
