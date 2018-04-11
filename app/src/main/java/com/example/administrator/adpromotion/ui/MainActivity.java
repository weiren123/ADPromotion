package com.example.administrator.adpromotion.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.MainContract;
import com.example.administrator.adpromotion.presenter.MainPresenter;
import com.orhanobut.logger.Logger;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View,TencentLocationListener {

    @BindView(R.id.mapview)
    MapView mapview;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.navigation)
    NavigationView navigation;
    private TencentLocationManager mLocationManager;
    private TencentMap tencentMap;
    private TencentLocation mLocation;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mLocationManager = TencentLocationManager.getInstance(mContext);
        tencentMap = mapview.getMap();
//        //设置卫星底图
//        tencentMap.setSatelliteEnabled(true);
//        //设置实时路况开启
//        tencentMap.setTrafficEnabled(true);
//        //设置地图中心点
        tencentMap.setPointToCenter(39, 116);
//        //设置缩放级别
        tencentMap.setMinZoomLevel(9);


        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLocation != null) {

                    // 地图视图
                    CameraUpdate cameraSigma = CameraUpdateFactory.newCameraPosition(new CameraPosition(
                            new LatLng(mLocation.getLatitude(), mLocation.getLongitude()), //新的中心点坐标
                            19,     // 新的缩放级别
                            0f,     // 俯仰角 0~45° (垂直地图时为0)
                            0f));   // 偏航角 0~360° (正北方为0)
                    // 移动地图
                    tencentMap.moveCamera(cameraSigma);
                }
            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void showUpdateDialog(String versionContent) {

    }

    @Override
    public void showMap(TencentLocation mLocation) {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
        startLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapview.onPause();
        stopLocation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
//        stopLocation();
    }

    @Override
    protected void onDestroy() {
        mapview.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLocationChanged(TencentLocation tencentLocation, int error, String s) {
        Logger.e(tencentLocation.getCity());
        if (error == TencentLocation.ERROR_OK) {
            mLocation = tencentLocation;
            Logger.e(mLocation.getAddress());
            if (mLocation != null) {

                // 地图视图
                CameraUpdate cameraSigma = CameraUpdateFactory.newCameraPosition(new CameraPosition(
                        new LatLng(mLocation.getLatitude(), mLocation.getLongitude()), //新的中心点坐标
                        19,     // 新的缩放级别
                        0f,     // 俯仰角 0~45° (垂直地图时为0)
                        0f));   // 偏航角 0~360° (正北方为0)
                // 移动地图
                tencentMap.moveCamera(cameraSigma);
            }
        }
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }

    public void startLocation() {
        TencentLocationRequest request = TencentLocationRequest.create();
        request.setInterval(5000);
        int flag = mLocationManager.requestLocationUpdates(request, this);
        Logger.e(flag+"");
    }
    public void stopLocation() {
        mLocationManager.removeUpdates(this);
    }
}
