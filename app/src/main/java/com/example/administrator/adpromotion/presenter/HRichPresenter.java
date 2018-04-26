package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.HRichContract;
import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.utils.RxUtil;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2018/4/26.
 */

public class HRichPresenter extends RxPresenter<HRichContract.View> implements HRichContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public HRichPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }


    @Override
    public void initHRichData() {
        mView.showHRichList();
    }

    @Override
    public void uploadImg(MultipartBody.Part file) {
        addSubscribe(mDataManager.uploadImg(file)
        .compose(RxUtil.<CommentBean>rxSchedulerHelper())
        .subscribe(new Consumer<CommentBean>() {
            @Override
            public void accept(@NonNull CommentBean commentBean) throws Exception {
                Logger.e("isSuccess:"+commentBean.getCode());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e("isError:"+throwable.getMessage());
            }
        }));
    }
}
