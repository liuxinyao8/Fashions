package com.example.fashions.interfaces.login;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.Register;

public interface RegisterContract {
    interface view extends IBaseView{
        void getregist(Register register);
    }
    interface presenter extends IPersenter<view>{
        void getRegisterp(String username ,String password);
    }
}
