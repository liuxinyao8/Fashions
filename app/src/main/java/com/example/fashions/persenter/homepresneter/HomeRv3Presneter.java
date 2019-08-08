package com.example.fashions.persenter.homepresneter;

import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.news.HomeRv3Contract;
import com.example.fashions.model.bean.HomeRv2Bean;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class HomeRv3Presneter extends BasePersenter<HomeRv3Contract.view>implements HomeRv3Contract.presenter {
    @Override
    public void getRv3p(int id) {
        addSubscribe(HttpManager.getMyApi().getRv3(id)
                .compose(RxUtils.<HomeRv2Bean> rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeRv2Bean>(mView){
                    @Override
                    public void onNext(HomeRv2Bean homeRv3Bean) {
                        mView.getRv3(homeRv3Bean);
                    }
                }));
    }
}
