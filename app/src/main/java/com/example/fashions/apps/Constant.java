package com.example.fashions.apps;

import java.io.File;

public class Constant {

    public static final String Base_Url = "http://cdwan.cn:8360/api/";
    public static final String login_Url = "https://cdwan.cn/api/";


    //网络缓存的地址
    public static final String PATH_DATA = MyApplication.app.getCacheDir().getAbsolutePath() + File.separator + "ShiXun";

    public static final String PATH_CACHE = PATH_DATA + "/Fashions";

}
