package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.JUserSendContract;
import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.SendContentBean;
import com.example.administrator.adpromotion.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/21.
 */

public class JUserSendPresenter extends RxPresenter<JUserSendContract.View> implements JUserSendContract.Presenter {

    private final DataManager mDataManager;

    @Inject
    public JUserSendPresenter(DataManager mDataManager){
        this.mDataManager = mDataManager;
    }
    @Override
    public void sendQuestionData(final SendContentBean sendContentBean) {
        addSubscribe(mDataManager.fetchSendData(sendContentBean.getAnswer_id(),
        sendContentBean.getTitle(),sendContentBean.getContent(),sendContentBean.getUser_id())
        .compose(RxUtil.<CommentBean>rxSchedulerHelper())
        .subscribe(new Consumer<CommentBean>() {
            @Override
            public void accept(@NonNull CommentBean commentBean) throws Exception {
                if("success".equals(commentBean.getCode())){
                    mView.joinSUser(sendContentBean.getUser_id());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                mView.showErrorMsg(throwable.getMessage());
            }
        }));
    }
}
