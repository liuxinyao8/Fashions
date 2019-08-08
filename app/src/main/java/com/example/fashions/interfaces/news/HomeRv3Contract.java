package com.example.fashions.interfaces.news;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.HomeRv2Bean;

public interface HomeRv3Contract {
    interface view extends IBaseView{
        void getRv3(HomeRv2Bean homeRv3Bean);
    }
    interface presenter extends IPersenter<view>{
        void getRv3p(int id);
    }
}
