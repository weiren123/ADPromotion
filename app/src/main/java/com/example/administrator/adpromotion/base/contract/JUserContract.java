package com.example.administrator.adpromotion.base.contract;

import android.app.Activity;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/20.
 */

public interface JUserContract {
    interface View extends BaseView{
        void showUserInfo(Map params);

        void eventSend(int userId, int str);
    }
    interface Presenter extends BasePresenter<View>{
        void getJuserDataInfo();

        void getFirsrData(Activity context);

    }
}
