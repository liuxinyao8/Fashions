package com.example.fashions.interfaces.login;

import com.example.fashions.interfaces.IBaseView;
import com.example.fashions.interfaces.IPersenter;
import com.example.fashions.model.bean.LoginBean;


public interface LoginContract {
    interface view extends IBaseView{
        void getLogin(LoginBean loginBean);
    }
    interface presenter extends IPersenter<view>{
        void getLoginp(String username,String password);
    }
}
