package com.example.administrator.adpromotion.presenter;

import android.Manifest;
import android.content.Context;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.MainContract;
import com.example.administrator.adpromotion.model.DataManager;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/10.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter,TencentLocationListener {
    private final Context mContext;
    DataManager mDataManager;
    private TencentLocationManager mLocationManager;
    private TencentLocation mLocation;

    @Inject
    public MainPresenter(App context, DataManager dataManager){
        this.mContext = context;
        this.mDataManager = dataManager;
    }

    @Override
    public void attchView(MainContract.View view) {
        super.attchView(view);
        mLocationManager = TencentLocationManager.getInstance(mContext);
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


    @Override
    public void onLocationChanged(TencentLocation tencentLocation, int error, String s) {
        Logger.e(tencentLocation.getAddress()+":onLocationChanged");
        if (error == TencentLocation.ERROR_OK) {
            mLocation = tencentLocation;
            if (mLocation != null) {
                mDataManager.saveLocationLatInfo((float) mLocation.getLatitude());
                mDataManager.saveLocationLongtInfo((float) mLocation.getLongitude());
                // 地图视图
                CameraUpdate cameraSigma = CameraUpdateFactory.newCameraPosition(new CameraPosition(
                        new LatLng(mLocation.getLatitude(), mLocation.getLongitude()), //新的中心点坐标
                        19,     // 新的缩放级别
                        0f,     // 俯仰角 0~45° (垂直地图时为0)
                        0f));   // 偏航角 0~360° (正北方为0)
                mView.setPointToCenter(cameraSigma);
//                mView.loctionMe(mDataManager);
            }
            Logger.e(mLocation.getAddress());
//            if (mLocation != null) {
//                mView.setPointToCenter((int)mLocation.getLatitude(),(int)mLocation.getLongitude());
//                mView.loctionMe(mLocation);
//            }
        }
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {
        Logger.e(s+":onStatusUpdate"+"--i="+i+"--s1="+s1);
    }
    @Override
    public void startLocation() {
        TencentLocationRequest request = TencentLocationRequest.create();
        request.setInterval(5000);
        int flag = mLocationManager.requestLocationUpdates(request, this);
        Logger.e(flag+"");
    }
    @Override
    public void stopLocation() {
        mLocationManager.removeUpdates(this);
    }
}
