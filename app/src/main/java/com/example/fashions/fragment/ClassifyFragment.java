package com.example.fashions.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fashions.R;
import com.example.fashions.adapter.fl_Adapter.Classify_Adapter;
import com.example.fashions.base.BaseFragment;
import com.example.fashions.interfaces.Classify.ClassifyContract;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.Classify;
import com.example.fashions.model.bean.Classify_RecyBean;
import com.example.fashions.persenter.classify.ClassifyPresneter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment implements ClassifyContract.view {

   private boolean selet;
    @BindView(R.id.fl_tablayout)
    VerticalTabLayout flTablayout;
    @BindView(R.id.fl_im)
    ImageView flIm;
    @BindView(R.id.fl_tv)
    TextView flTv;
    @BindView(R.id.fl_rv)
    RecyclerView flRv;
    private List<Classify.DataBean.CategoryListBean> categoryList;
    private Classify_Adapter classify_adapter;
   private int id;
    private ArrayList<Classify_RecyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView(Bundle bundle) {
        subCategoryListBeans = new ArrayList<>();
        classify_adapter = new Classify_Adapter(subCategoryListBeans, getContext());
        flRv.setAdapter(classify_adapter);

        flTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabView tab, int position) {
        init(position);
    }

    @Override
    public void onTabReselected(TabView tab, int position) {

    }
});
    }
int lastposition;
    private void init(int position) {
        id = categoryList.get(position).getId();
        flTv.setText("------"+categoryList.get(position).getName()+"------");
        Glide.with(getActivity()).load(categoryList.get(position).getBanner_url()).into(flIm);

           if (position!=lastposition){
               subCategoryListBeans.clear();
           }
        ((ClassifyPresneter)persenter).getClassifybean(this.id);
           lastposition=position;
    }

    @Override
    protected void initData() {
        ((ClassifyPresneter)persenter).getClassifyp();
    }

    @Override
    protected IPersenter createPersenter() {
        return new ClassifyPresneter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    public void getClassify(Classify classify) {
        categoryList = classify.getData().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            flTablayout.addTab(new QTabView(getActivity()).setTitle(new TabView.TabTitle.Builder()
                    .setContent(categoryList.get(i).getName())
                    .build()));
        }
        init(0);
    }

    @Override
    public void getClassifybean(Classify_RecyBean classify_recyBean) {
        List<Classify_RecyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = classify_recyBean.getData().getCurrentCategory().getSubCategoryList();
        subCategoryListBeans.addAll(subCategoryList);
        flRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        classify_adapter.notifyDataSetChanged();
    }
}
