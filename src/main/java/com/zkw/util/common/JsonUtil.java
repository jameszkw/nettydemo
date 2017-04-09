package com.zkw.util.common;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class JsonUtil {
    public static String object2Json(Object o)throws Exception{
        Gson gson=new Gson();
        return gson.toJson(o);
    }

    public static Object json2Object(String s){
        Gson gson=new Gson();
        return gson.fromJson(s,Object.class);
    }
}
