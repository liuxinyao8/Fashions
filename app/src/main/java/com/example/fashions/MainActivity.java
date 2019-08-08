package com.example.fashions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fashions.base.BaseActivity;
import com.example.fashions.fragment.ClassifyFragment;
import com.example.fashions.fragment.HomeFragment;
import com.example.fashions.fragment.MyFragment;
import com.example.fashions.fragment.ShoppingFragment;
import com.example.fashions.fragment.SpecialFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private TabLayout tablout;
    private Toolbar toolbar;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tablout = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new ShoppingFragment());
        MyFragment myFragment = new MyFragment();
        fragments.add(myFragment);

      initfra(fragments.get(0));
        tablout.addTab(tablout.newTab().setText("首页").setIcon(R.drawable.home_select));
        tablout.addTab(tablout.newTab().setText("专题").setIcon(R.drawable.zhuanti_select));
        tablout.addTab(tablout.newTab().setText("分类").setIcon(R.drawable.fenlei_select));
        tablout.addTab(tablout.newTab().setText("购物车").setIcon(R.drawable.shopping_select));
        tablout.addTab(tablout.newTab().setText("我的").setIcon(R.drawable.my_select));
     tablout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
         @Override
         public void onTabSelected(TabLayout.Tab tab) {
             switch (tab.getPosition()){
                 case 0:
                     initfra(fragments.get(0));
                     break;
                 case 1:
                     initfra(fragments.get(1));
                     break;
                 case 2:
                     initfra(fragments.get(2));
                     break;
                 case 3:
                     initfra(fragments.get(3));
                     break;
                 case 4:
                     initfra(fragments.get(4));
                     break;

             }
         }

         @Override
         public void onTabUnselected(TabLayout.Tab tab) {

         }

         @Override
         public void onTabReselected(TabLayout.Tab tab) {

         }
     });

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        Bundle bundle = new Bundle();
        bundle.putString("username",name);
        myFragment.setArguments(bundle);

    }

    private void initfra(Fragment fragments){
        if (manager ==null){
            manager = getSupportFragmentManager();
        }
        FragmentTransaction transaction = manager.beginTransaction();

        if (!fragments.isAdded()){
            List<Fragment> fgs = manager.getFragments();
            transaction.addToBackStack(null);
            if (fgs.size()>0){
                for (Fragment ff:fgs) {
                    transaction.hide(ff);
                }

            }
            transaction.add(R.id.fl,fragments);

        }else {
            List<Fragment> fgs = manager.getFragments();
            if (fgs.size()>0){
                for (Fragment fra:fgs) {
                    transaction.hide(fra);
                }
            }
            transaction.show(fragments);
        }
        transaction.commit();
    }
}
