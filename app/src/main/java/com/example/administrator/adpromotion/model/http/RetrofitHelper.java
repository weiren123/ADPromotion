package com.example.administrator.adpromotion.model.http;

import com.example.administrator.adpromotion.model.FirstBean;
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
    public Flowable<WelcomeBaen> fetchWelcomeInfo(String s1,String s2,String s3,String s4) {
        return apis.getWelcomeInfo(s1,s2,s3,s4);
    }

    @Override
    public Flowable<FirstBean> fetchFirstDataInfo() {
        return apis.getFirstData();
    }
}
