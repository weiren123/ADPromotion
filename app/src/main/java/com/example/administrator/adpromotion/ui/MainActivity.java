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
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.presenter.MainPresenter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

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
    private TencentMap tencentMap;
    private CameraUpdate cameraSigma;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        checkPermissions();
        tencentMap = mapview.getMap();
        //        //设置地图中心点
        tencentMap.setPointToCenter(39, 162);
//        //设置缩放级别
        tencentMap.setMinZoomLevel(9);
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void showUpdateDialog(String versionContent) {

    }

    @Override
    public void showMap(CameraUpdate cameraUpdate) {
        tencentMap.moveCamera(cameraUpdate);
    }

    @Override
    public void loctionMe(DataManager dataManager) {
        float latitude = dataManager.getLocationLongInfo();
        float longitude = dataManager.getLocationLongInfo();
        latitude = (float)36;
        longitude = (float) 162;
        final double finalLatitude = latitude;
        final double finalLongitude = longitude;

        // 移动地图
        tencentMap.moveCamera(cameraSigma);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 地图视图
                CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(
                        new CameraPosition(
                                new LatLng(finalLatitude, finalLongitude), //新的中心点坐标
                                19,     // 新的缩放级别
                                0f,     // 俯仰角 0~45° (垂直地图时为0)
                                0f));// 偏航角 0~360° (正北方为0)
            // 移动地图
                mapview.getMap().setPointToCenter((int)finalLatitude,(int) finalLongitude);
                mapview.getMap().animateCamera(cameraUpdate);
//                tencentMap.moveCamera(cameraUpdate);
            }
        });
    }

    @Override
    public void setPointToCenter(CameraUpdate cameraUpdate) {
        // 移动地图
        tencentMap.animateCamera(cameraUpdate);
    }

    public void checkPermissions() {
        mPresenter.checkPermissions(new RxPermissions(this));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
        mPresenter.startLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapview.onPause();
        mPresenter.stopLocation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
        mPresenter.stopLocation();
    }

    @Override
    protected void onDestroy() {
        mapview.onDestroy();
        super.onDestroy();
    }
}
