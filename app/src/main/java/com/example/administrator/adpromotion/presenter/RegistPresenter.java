package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.RegistContract;
import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/23.
 */

public class RegistPresenter extends RxPresenter<RegistContract.View> implements RegistContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public RegistPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }

    @Override
    public void registUser(String phone,String pwd) {
        addSubscribe(mDataManager.fetchregistUser(phone,pwd)
        .compose(RxUtil.<CommentBean>rxSchedulerHelper())
        .subscribe(new Consumer<CommentBean>() {
            @Override
            public void accept(@NonNull CommentBean commentBean) throws Exception {
                if("success".equals(commentBean.getCode())){
                    mView.JoinLogin();
                }else {
                    mView.showErrorMsg(commentBean.getMsg());
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
