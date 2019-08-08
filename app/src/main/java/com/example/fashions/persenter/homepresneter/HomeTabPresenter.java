package com.example.fashions.persenter.homepresneter;

import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.news.HomeTabContract;
import com.example.fashions.model.bean.HomeTableBean;
import com.example.fashions.model.bean.IndexBean;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class HomeTabPresenter extends BasePersenter<HomeTabContract.view>implements HomeTabContract.presenter {
    @Override
    public void getHomeTableP() {
        addSubscribe(HttpManager.getMyApi().getTabBean()
                .compose(RxUtils.<HomeTableBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeTableBean>(mView){
                    @Override
                    public void onNext(HomeTableBean homeTableBean) {
                        mView.getHomeTable(homeTableBean);
                    }
                }));
    }
}
