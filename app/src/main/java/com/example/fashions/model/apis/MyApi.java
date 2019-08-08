package com.example.fashions.model.apis;


import com.example.fashions.model.bean.Classify;
import com.example.fashions.model.bean.Classify_RecyBean;
import com.example.fashions.model.bean.HomeRv2Bean;
import com.example.fashions.model.bean.HomeTableBean;
import com.example.fashions.model.bean.IndexBean;
import com.example.fashions.model.bean.LoginBean;
import com.example.fashions.model.bean.Register;
import com.example.fashions.model.bean.SpecialBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApi {
//首页
    @GET("index/index")
    Flowable<IndexBean> getIndexData();
//首页新品。
    @GET("goods/detail")
    Flowable<HomeRv2Bean>getRv3(@Query("id")int id);

    //首页tab
    @GET("goods/list")
    Flowable<HomeTableBean>getTabBean();

    //专题
    @GET("topic/list")
    Flowable<SpecialBean>getZhuanlan();
    //分类
    @GET("catalog/index")
    Flowable<Classify>getClassify();
    //分类目录
    @GET("catalog/current")
    Flowable<Classify_RecyBean>getClassifygreeBean(@Query("id")int id);

    //注册
    @POST("login/register")
    @FormUrlEncoded
    Flowable<Register>getregister(@Field("username") String username,@Field("password")String password);
    //登陆
    @POST("login/login")
    @FormUrlEncoded
    Flowable<LoginBean>getLogin(@Field("username") String username, @Field("password")String password);

}
