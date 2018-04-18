package com.example.administrator.adpromotion.model;

import com.example.administrator.adpromotion.model.http.HttpHelper;
import com.example.administrator.adpromotion.model.prefs.Preferenceshelper;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/4.
 */

public class DataManager implements HttpHelper,Preferenceshelper {
    Preferenceshelper preferencesHeller;
    HttpHelper httpHelper;
    public DataManager(HttpHelper httpHelper,Preferenceshelper preferencesHeller){
        this.httpHelper = httpHelper;
        this.preferencesHeller = preferencesHeller;
    }

    @Override
    public Flowable<WelcomeBaen> fetchWelcomeInfo(String s1,String s2,String s3,String s4) {
        return httpHelper.fetchWelcomeInfo(s1,s2,s3,s4);
    }

    @Override
    public Flowable<FirstBean> fetchFirstDataInfo() {
        return httpHelper.fetchFirstDataInfo();
    }

    @Override
    public void saveLocationLatInfo(float latitude) {
        preferencesHeller.saveLocationLatInfo(latitude);
    }

    @Override
    public void saveLocationLongtInfo(float longitude) {
        preferencesHeller.saveLocationLongtInfo(longitude);
    }

    @Override
    public float getLocationLatInfo() {
        return preferencesHeller.getLocationLatInfo();
    }

    @Override
    public float getLocationLongInfo() {
        return preferencesHeller.getLocationLongInfo();
    }
}
