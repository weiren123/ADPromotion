package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.SUserListContract;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.SUserListBean;
import com.example.administrator.adpromotion.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/21.
 */

public class SUserListPresenter extends RxPresenter<SUserListContract.View> implements SUserListContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public SUserListPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }
    @Override
    public void getSuserData(int id) {
        addSubscribe(mDataManager.fetchGetSListData(id)
        .compose(RxUtil.<SUserListBean>rxSchedulerHelper())
        .subscribe(new Consumer<SUserListBean>() {
            @Override
            public void accept(@NonNull SUserListBean sUserListBean) throws Exception {
                mView.showList(sUserListBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                mView.showErrorMsg(throwable.getMessage());
            }
        }));
    }
}
