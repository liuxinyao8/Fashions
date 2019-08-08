package com.example.fashions.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fashions.R;
import com.example.fashions.model.bean.IndexBean;

import java.util.List;

public class HomeAdapter5 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<IndexBean.DataBean.CategoryListBean> categoryList;
    private Context context;
    private HomeAdapter5_2 homeAdapter5_2;

    public HomeAdapter5(List<IndexBean.DataBean.CategoryListBean> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_item5_1, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IndexBean.DataBean.CategoryListBean categoryListBean = categoryList.get(i);
            ViewHolder1 viewHolder1=(ViewHolder1)viewHolder;
            viewHolder1.tv.setText(categoryListBean.getName());

            List<IndexBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
            viewHolder1.rv.setLayoutManager(new GridLayoutManager(context,2));
            homeAdapter5_2 = new HomeAdapter5_2(goodsList, context);
            viewHolder1.rv.setAdapter(homeAdapter5_2);
            homeAdapter5_2.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        private TextView tv;
        private RecyclerView rv;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.home_rv5_tv1);
            rv=itemView.findViewById(R.id.home_rv5_rv2);
        }
    }

}
