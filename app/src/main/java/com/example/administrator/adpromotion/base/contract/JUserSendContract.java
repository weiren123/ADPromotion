package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.SendContentBean;

/**
 * Created by Administrator on 2018/4/20.
 */

public interface JUserSendContract {
    interface View extends BaseView{

        void joinSUser(int id);
    }
    interface Presenter extends BasePresenter<View>{
        void sendQuestionData(SendContentBean sendContentBean);
    }
}
