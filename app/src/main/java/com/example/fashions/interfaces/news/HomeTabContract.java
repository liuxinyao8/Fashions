package com.example.fashions.interfaces.news;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.HomeTableBean;
import com.example.fashions.ui.HomeTable;

public interface HomeTabContract {
    interface view extends IBaseView{
        void getHomeTable(HomeTableBean homeTableBean);
    }
    interface presenter extends IPersenter<view>{
        void getHomeTableP();
    }
}
