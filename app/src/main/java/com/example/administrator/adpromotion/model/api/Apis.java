package com.example.administrator.adpromotion.model.api;

import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.model.WelcomeBaen;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/4/4.
 */

public interface Apis {
    String HOST = "http://10.63.205.74:5000/";

    @POST("regist/")
    @FormUrlEncoded
    Flowable<WelcomeBaen> getWelcomeInfo(@Field("telephone") String telephone,
                                         @Field("username") String username,
                                         @Field("password1") String password1,
                                        @Field("password2") String password2);
    @GET("userinfo_list/")
    Flowable<FirstBean> getFirstData();



}
