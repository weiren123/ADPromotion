package com.example.administrator.adpromotion.model;

import com.example.administrator.adpromotion.model.http.HttpHelper;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/4.
 */

public class DataManager implements HttpHelper {
    HttpHelper httpHelper;
    public DataManager(HttpHelper httpHelper){
        this.httpHelper = httpHelper;
    }

    @Override
    public Flowable<WelcomeBaen> fetchWelcomeInfo() {
        return httpHelper.fetchWelcomeInfo();
    }
}
