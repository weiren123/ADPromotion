package com.example.administrator.adpromotion.model.api;

import com.example.administrator.adpromotion.model.WelcomeBaen;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/4/4.
 */

public interface Apis {
    String HOST = "http://10.63.205.74:5000/";

    @GET("startimage")
    Flowable<WelcomeBaen> getWelcomeInfo();
}
