package com.example.fashions.interfaces.Specia;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.SpecialBean;

public interface SpeciaContract {
    interface View extends IBaseView{
        void getzhaunglan1(SpecialBean specialBean);
    }
    interface Presenter extends IPersenter<View>{
        void getZhuangLan();
    }
}
