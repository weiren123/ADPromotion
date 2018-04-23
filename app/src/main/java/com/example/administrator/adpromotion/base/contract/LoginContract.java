package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;

/**
 * Created by Administrator on 2018/4/23.
 */

public interface LoginContract {
    interface View extends BaseView{
        void joinMain();
    }
    interface  Presenter extends BasePresenter<View>{
        void login(String p,String pwd);
    }
}
