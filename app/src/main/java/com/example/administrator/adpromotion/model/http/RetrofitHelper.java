package com.example.administrator.adpromotion.model.http;

import com.example.administrator.adpromotion.model.WelcomeBaen;
import com.example.administrator.adpromotion.model.api.Apis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/4.
 */

public class RetrofitHelper implements HttpHelper {
    private Apis apis;

    @Inject
    public RetrofitHelper(Apis apis){
        this.apis = apis;
    }

    @Override
    public Flowable<WelcomeBaen> fetchWelcomeInfo() {
        return apis.getWelcomeInfo();
    }
}
