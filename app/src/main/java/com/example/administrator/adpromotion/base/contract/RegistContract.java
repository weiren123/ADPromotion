package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;

/**
 * Created by Administrator on 2018/4/23.
 */

public interface RegistContract {

    interface View extends BaseView{
        void JoinLogin();
    }
    interface Presenter extends BasePresenter<View>{
        void registUser(String phone,String pwd);
    }
}
