package com.example.fashions.adapter.my_adapter;

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
import com.example.fashions.model.bean.My_Rv_Bean;

import java.util.ArrayList;

public class My_Adapter extends RecyclerView.Adapter<My_Adapter.ViewHolder> {
    private ArrayList<My_Rv_Bean>rv_beans;
    private Context context;

    public My_Adapter(ArrayList<My_Rv_Bean> rv_beans, Context context) {
        this.rv_beans = rv_beans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_re_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
      viewHolder.tv.setText(rv_beans.get(i).getTv1());
        Glide.with(context).load(rv_beans.get(i).getImage()).into(viewHolder.im);
    }

    @Override
    public int getItemCount() {
        return rv_beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.my_rv_im);
            tv=itemView.findViewById(R.id.my_rv_tv);
        }
    }
}
