package com.example.fashions.interfaces.Classify;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.Classify;
import com.example.fashions.model.bean.Classify_RecyBean;

public interface ClassifyContract {
    interface view extends IBaseView{
        void getClassify(Classify classify);
        void getClassifybean(Classify_RecyBean classify_recyBean);
    }
    interface presenter extends IPersenter<view>{
        void getClassifyp();
        void getClassifybean(int id);
    }
}
