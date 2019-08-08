package com.example.fashions.persenter.login;

import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.login.LoginContract;
import com.example.fashions.interfaces.login.RegisterContract;
import com.example.fashions.model.bean.LoginBean;
import com.example.fashions.model.bean.Register;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class RegisterPresenter extends BasePersenter<RegisterContract.view>implements RegisterContract.presenter {

    @Override
    public void getRegisterp(String username, String password) {
        addSubscribe(HttpManager.getMyApi1().getregister(username,password)
                .compose(RxUtils.<Register> rxScheduler())
                .subscribeWith(new CommonSubscriber<Register>(mView){
                    @Override
                    public void onNext(Register register) {
                        mView.getregist(register);
                    }
                }));
    }
}
