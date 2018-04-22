package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.SUserListBean;

/**
 * Created by Administrator on 2018/4/21.
 */

public interface SUserListContract {
    interface View extends BaseView{
        void showList(SUserListBean sUserListBean);
    }
    interface Presenter extends BasePresenter<View>{
        void getSuserData(int id);
    }
}
