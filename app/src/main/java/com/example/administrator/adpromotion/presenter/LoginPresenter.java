package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.LoginContract;
import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/23.
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter{
    private final DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }
    @Override
    public void login(String phone,String pwd) {
        addSubscribe(mDataManager.fetchLoginUser(phone,pwd)
        .compose(RxUtil.<CommentBean>rxSchedulerHelper())
        .subscribe(new Consumer<CommentBean>() {
            @Override
            public void accept(@NonNull CommentBean commentBean) throws Exception {
                if("success".equals(commentBean.getCode())){
                    mView.joinMain();
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
