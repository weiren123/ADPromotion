package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.DataManager;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;

/**
 * Created by Administrator on 2018/4/10.
 */

public interface MainContract {
     interface View extends BaseView{
        void showUpdateDialog(String versionContent);
        void showMap(CameraUpdate cameraUpdate);
        void loctionMe(DataManager dataManager);
         void setPointToCenter(CameraUpdate cameraUpdate);
    }
     interface Presenter extends BasePresenter<View>{
        void checkPermissions(RxPermissions permissions);

         void startLocation();

         void stopLocation();
    }
}
