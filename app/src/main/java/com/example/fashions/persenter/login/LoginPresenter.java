package com.example.fashions.persenter.login;

import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.login.LoginContract;
import com.example.fashions.model.bean.IndexBean;
import com.example.fashions.model.bean.LoginBean;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class LoginPresenter extends BasePersenter<LoginContract.view>implements LoginContract.presenter {
    @Override
    public void getLoginp(String username, String password) {
        addSubscribe(HttpManager.getMyApi1().getLogin(username,password)
                .compose(RxUtils.<LoginBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginBean>(mView){
                    @Override
                    public void onNext(LoginBean loginBean) {
                        mView.getLogin(loginBean);
                    }
                }));
    }
}
