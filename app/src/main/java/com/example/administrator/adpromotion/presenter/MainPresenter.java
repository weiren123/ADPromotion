package com.example.administrator.adpromotion.presenter;

import android.Manifest;
import android.content.Context;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.MainContract;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.map.geolocation.TencentLocationManager;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private final Context mContext;
    private TencentLocationManager mLocationManager;
    private String mRequestParams;

    @Inject
    public MainPresenter(App context){
        this.mContext = context;
    }

    @Override
    public void attchView(MainContract.View view) {
        super.attchView(view);

    }

    @Override
    public void checkPermissions(RxPermissions permissions) {
        addSubscribe(permissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
        .subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(@NonNull Boolean granted) throws Exception {
                if (granted) {
                    Logger.e("定位权限:"+granted);
                } else {
                    mView.showErrorMsg("定位权限没有开启~~");
                }
            }
        }));
    }


}
