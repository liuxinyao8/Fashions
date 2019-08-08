package com.example.fashions.persenter.Specialpresenter;

import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.Specia.SpeciaContract;
import com.example.fashions.model.bean.IndexBean;
import com.example.fashions.model.bean.SpecialBean;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class SpecialPresneter extends BasePersenter<SpeciaContract.View>implements SpeciaContract.Presenter {
    @Override
    public void getZhuangLan() {
        addSubscribe(HttpManager.getMyApi().getZhuanlan()
                .compose(RxUtils.<SpecialBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<SpecialBean>(mView){
                    @Override
                    public void onNext(SpecialBean specialBean) {
                        mView.getzhaunglan1(specialBean);
                    }
                }));
    }
}
