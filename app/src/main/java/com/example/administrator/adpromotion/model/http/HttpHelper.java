package com.example.administrator.adpromotion.model.http;

import com.example.administrator.adpromotion.model.WelcomeBaen;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/4.
 */

public interface HttpHelper {

    Flowable<WelcomeBaen> fetchWelcomeInfo();
}
