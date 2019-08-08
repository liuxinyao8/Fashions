package com.example.fashions.interfaces.news;


import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.IndexBean;

import java.util.List;

public interface NewsContract {
    //主页数据
    interface View extends IBaseView {

        void getIndexReturn(IndexBean indexBean);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        void getIndex();

    }
}