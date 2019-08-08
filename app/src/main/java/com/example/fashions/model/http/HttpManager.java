package com.example.fashions.model.http;


import com.example.fashions.apps.Constant;
import com.example.fashions.model.apis.MyApi;
import com.example.fashions.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static Cache cache;

    private static MyApi myApi;

    //创建Retrofit对象
    private static Retrofit getRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOkhttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * 创建带缓存的HttpClient对象
     * @return
     */
    private static OkHttpClient getOkhttpClient() {
        //本地缓存文件
        File file = new File(Constant.PATH_CACHE);
        //设置缓存文件的大小100M
        cache = new Cache(file, 1024 * 1024 * 100);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new Myintercepter())
                .addNetworkInterceptor(new Myintercepter())
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    //获取相关的网络接口 baseURL基础地址  tCla 用来做数据加载的接口类
    private static synchronized <T> T getServerApis(String baseUrl,Class<T> tCla){
        return getRetrofit(baseUrl).create(tCla);
    }


    /**
     * 获取api接口
     * @return
     */
    public static MyApi getMyApi(){
        synchronized (HttpManager.class){
            if(myApi == null){
                synchronized (HttpManager.class){
                    myApi = getServerApis(Constant.Base_Url,MyApi.class);
                }
            }
        }
        return myApi;
    }
    public static MyApi getMyApi1(){
        synchronized (HttpManager.class){
            if(myApi == null){
                synchronized (HttpManager.class){
                    myApi = getServerApis(Constant.login_Url,MyApi.class);
                }
            }
        }
        return myApi;
    }

    //拦截器的实现类
    private static class Myintercepter implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if(!SystemUtils.checkNetWork()){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            //通过判断网络连接是否存在获取本地或者服务器的数据
            if(!SystemUtils.checkNetWork()){
                int maxAge = 0;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public ,max-age="+maxAge).build();
            }else{
                int maxStale = 60*60*24*28; //设置缓存数据的保存时间
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public, onlyif-cached, max-stale="+maxStale).build();
            }
        }
    }

}
