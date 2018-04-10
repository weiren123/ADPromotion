package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.MainContract;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    @Override
    public void checkPermissions(RxPermissions permissions) {

    }
}
