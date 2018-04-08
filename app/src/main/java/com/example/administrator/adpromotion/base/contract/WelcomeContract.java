package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.WelcomeBaen;

/**
 * @author
 * Created by Administrator on 2018/3/28.
 */

public interface WelcomeContract {
    interface View extends BaseView{
        void showContent(WelcomeBaen welcomeBaen);

        void joinMain();
    }
    interface  Presenter extends BasePresenter<View>{
        void getWelcomeData();
    }
}
