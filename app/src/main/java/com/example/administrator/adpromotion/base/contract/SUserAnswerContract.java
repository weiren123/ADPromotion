package com.example.administrator.adpromotion.base.contract;

import android.app.Activity;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;
import com.example.administrator.adpromotion.model.QuestionBean;
import com.example.administrator.adpromotion.model.SUserAnswerBean;

/**
 * Created by Administrator on 2018/4/22.
 */

public interface SUserAnswerContract {
    interface View extends BaseView{
        void showQuestion(QuestionBean questionBean);

//        void showAnswerList(QuestionBean questionBean);

        void showAnswersList(SUserAnswerBean sUserAnswerBean);

        void refreshView();
    }
    interface Presenter extends BasePresenter<View>{
        void getPreActivityData(Activity activity);

        void addanswerData(QuestionBean questionBean);

        void getSUserAnswerData(QuestionBean questionBean);
    }
}
