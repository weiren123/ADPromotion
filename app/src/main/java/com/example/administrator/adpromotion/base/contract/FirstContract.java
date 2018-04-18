package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.FirstBean;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface FirstContract{
    interface View extends BaseView{
        void showBanner();
        void showList(FirstBean firstBean);
    }

    interface Presenter extends BasePresenter<View>{
        void getFirstData();
    }
}
