package com.example.administrator.adpromotion.presenter;

import android.app.Activity;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.SUserAnswerContract;
import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.QuestionBean;
import com.example.administrator.adpromotion.model.SUserAnswerBean;
import com.example.administrator.adpromotion.utils.RxUtil;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/22.
 */

public class SUserAnswerPresenter extends RxPresenter<SUserAnswerContract.View> implements SUserAnswerContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public SUserAnswerPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }

    @Override
    public void getPreActivityData(Activity activity) {
        String creatTime = activity.getIntent().getStringExtra("create_time");
        String content = activity.getIntent().getStringExtra("content");
        String title = activity.getIntent().getStringExtra("title");
        int answer_id = activity.getIntent().getIntExtra("answer_id",0);
        int user_id = activity.getIntent().getIntExtra("user_id",0);
        QuestionBean questionBean = new QuestionBean();
        questionBean.setUserId(user_id);
        questionBean.setAnswerId(answer_id);
        questionBean.setCreatTime(creatTime);
        questionBean.setContent(content);
        questionBean.setTitle(title);
        mView.showQuestion(questionBean);
        getSUserAnswerData(questionBean);
    }

    @Override
    public void addanswerData(QuestionBean questionBean) {
        addSubscribe(mDataManager.fetchaddAnswerData(questionBean.getUserId(),questionBean.getContent()
        ,questionBean.getUserId())
        .compose(RxUtil.<CommentBean>rxSchedulerHelper())
        .subscribe(new Consumer<CommentBean>() {
            @Override
            public void accept(@NonNull CommentBean commentBean) throws Exception {
                mView.refreshView();
                Logger.e("commentBean:"+commentBean.getMsg());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e("throwable:"+throwable.getMessage());
            }
        }));
    }

    @Override
    public void getSUserAnswerData(QuestionBean questionBean) {
        addSubscribe(mDataManager.fetchanswerListData(questionBean.getAnswerId(),questionBean.getUserId())
        .compose(RxUtil.<SUserAnswerBean>rxSchedulerHelper())
        .subscribe(new Consumer<SUserAnswerBean>() {
            @Override
            public void accept(@NonNull SUserAnswerBean sUserAnswerBean) throws Exception {
                mView.showAnswersList(sUserAnswerBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                mView.showErrorMsg(throwable.getMessage());
            }
        }));
    }
}
