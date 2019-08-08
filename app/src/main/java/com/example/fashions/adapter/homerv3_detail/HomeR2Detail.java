package com.example.fashions.adapter.homerv3_detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fashions.R;
import com.example.fashions.model.bean.HomeRv2Bean;

import java.util.List;

public class HomeR2Detail extends RecyclerView.Adapter<HomeR2Detail.ViewHolder> {
    private List<HomeRv2Bean.DataBeanX.IssueBean> issue;
    private Context context;

    public HomeR2Detail(List<HomeRv2Bean.DataBeanX.IssueBean> issue, Context context) {
        this.issue = issue;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_rv3_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
viewHolder.tv1.setText(issue.get(i).getQuestion());
viewHolder.tv2.setText(issue.get(i).getAnswer());

    }

    @Override
    public int getItemCount() {
        return issue.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.home_rv3rv_tv1);
            tv2=itemView.findViewById(R.id.home_rv3rv_tv2);
        }
    }
}
