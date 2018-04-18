package com.example.administrator.adpromotion.model.http;

import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.model.WelcomeBaen;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/4.
 */

public interface HttpHelper {

    Flowable<WelcomeBaen> fetchWelcomeInfo(String s1,String s2,String s3,String s4);

    Flowable<FirstBean> fetchFirstDataInfo();
}
