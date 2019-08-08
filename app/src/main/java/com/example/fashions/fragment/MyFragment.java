package com.example.fashions.fragment;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.fashions.R;
import com.example.fashions.adapter.my_adapter.My_Adapter;
import com.example.fashions.base.BaseFragment;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.My_Rv_Bean;
import com.example.fashions.ui.LoginActivity;
import com.example.fashions.ui.RegistActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.my_tx)
    ImageView myTx;
    @BindView(R.id.my_dl)
    ImageView myDl;
    @BindView(R.id.my_rv)
    RecyclerView myRv;
    @BindView(R.id.my_ddl)
    TextView myDdl;
    Unbinder unbinder;
    private ArrayList<My_Rv_Bean> my_rv_beans;
    private My_Adapter my_adapter;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView(Bundle bundle) {
        myTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_login, null);
                final PopupWindow popupWindow = new PopupWindow(inflate, 300, 200);
                popupWindow.showAsDropDown(myTx);
                TextView login_tv1 = inflate.findViewById(R.id.login_tv1);
                TextView login_tv2 = inflate.findViewById(R.id.login_tv2);
                login_tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        popupWindow.dismiss();
                    }
                });
                login_tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), RegistActivity.class));
                        popupWindow.dismiss();
                    }
                });
            }
        });

        Bundle bundle1 = getArguments();
        String username = bundle1.getString("username");
        myDdl.setText(username);

        myRv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        my_rv_beans = new ArrayList<>();
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.dd, "我的订单"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.yhq, "优惠券"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.lpk, "礼品卡"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.dzgl, "我的收藏"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.zhaq, "我的足迹"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.kf, "会员福利"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.dzgl, "地址管理"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.zhaq, "账号安全"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.kf, "联系客服"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.lx, "帮助中心"));
        my_rv_beans.add(new My_Rv_Bean(R.mipmap.yj, "意见反馈"));
        my_adapter = new My_Adapter(my_rv_beans, getActivity());
        myRv.setAdapter(my_adapter);
        my_adapter.notifyDataSetChanged();
//        myRv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        myRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#E6E6E6"));
                c.drawRect(0, 0, 3000, 3000, paint);
            }

            @Override
            public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
            }

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = parent.getChildAdapterPosition(view);
                if (position == 2 || position == 5 || position == 8) {
                    outRect.set(0, 0, 0, 5);
                } else if (position == 9 || position == 10 || position == 11) {
                    outRect.set(0, 0, 5, 0);
                } else {
                    outRect.set(0, 0, 5, 5);
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }


}
