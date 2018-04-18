package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.FirstContract;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.utils.RxUtil;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/18.
 */

public class FirstPresenter extends RxPresenter<FirstContract.View> implements FirstContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public FirstPresenter(DataManager mDataManager){
        this.mDataManager = mDataManager;
    }
    @Override
    public void getFirstData() {
        addSubscribe(mDataManager.fetchFirstDataInfo()
        .compose(RxUtil.<FirstBean>rxSchedulerHelper())
        .subscribe(new Consumer<FirstBean>() {
            @Override
            public void accept(@NonNull FirstBean firstBean) throws Exception {
                Logger.e("FirstDataInfo:" + firstBean.getMsg());
                mView.showList(firstBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e("FirstDataInfo:" + throwable.getMessage());
            }
        }));

        mView.showBanner();
    }
}
