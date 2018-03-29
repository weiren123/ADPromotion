package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.WelcomeContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/28.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {
    @Inject
    public WelcomePresenter(){}
    @Override
    public void getWelcomeData() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            mView.joinMain();
        }
    }
}
