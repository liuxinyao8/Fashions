package com.example.fashions.persenter.classify;

import com.example.fashions.base.BasePersenter;
import com.example.fashions.component.CommonSubscriber;
import com.example.fashions.interfaces.Classify.ClassifyContract;
import com.example.fashions.model.bean.Classify;
import com.example.fashions.model.bean.Classify_RecyBean;
import com.example.fashions.model.http.HttpManager;
import com.example.fashions.utils.RxUtils;

public class ClassifyPresneter extends BasePersenter<ClassifyContract.view>implements ClassifyContract.presenter {
    @Override
    public void getClassifyp() {
        addSubscribe(HttpManager.getMyApi().getClassify()
                .compose(RxUtils.<Classify> rxScheduler())
                .subscribeWith(new CommonSubscriber<Classify>(mView){
                    @Override
                    public void onNext(Classify classify) {
                        mView.getClassify(classify);
                    }
                }));
    }

    @Override
    public void getClassifybean(int id) {
        addSubscribe(HttpManager.getMyApi().getClassifygreeBean(id)
                .compose(RxUtils.<Classify_RecyBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<Classify_RecyBean>(mView){
                    @Override
                    public void onNext(Classify_RecyBean classify_recyBean) {
                        mView.getClassifybean(classify_recyBean);
                    }
                }));
    }
}
