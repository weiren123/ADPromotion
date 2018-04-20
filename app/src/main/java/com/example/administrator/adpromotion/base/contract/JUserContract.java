package com.example.administrator.adpromotion.base.contract;

import android.app.Activity;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.FirstBean;

/**
 * Created by Administrator on 2018/4/20.
 */

public interface JUserContract {
    interface View extends BaseView{
        void showUserInfo(FirstBean firstBean);
    }
    interface Presenter extends BasePresenter<View>{
        void getJuserDataInfo();

        void getFirsrData(Activity context);
    }
}
