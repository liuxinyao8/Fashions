package com.example.fashions.persenter.homepresneter;


import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.news.NewsContract;
import com.example.fashions.model.bean.IndexBean;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class MyPersenter extends BasePersenter<NewsContract.View> implements NewsContract.Presenter {


    @Override
    public void getIndex() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
        .compose(RxUtils.<IndexBean> rxScheduler())
        .subscribeWith(new CommonSubscriber<IndexBean>(mView){
            @Override
            public void onNext(IndexBean indexBean) {
                mView.getIndexReturn(indexBean);
            }
        }));
    }
}