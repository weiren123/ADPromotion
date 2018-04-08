package com.example.administrator.adpromotion.presenter;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.WelcomeContract;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.WelcomeBaen;
import com.example.administrator.adpromotion.utils.RxUtil;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/3/28.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {
    private DataManager dataManager;

    @Inject
    public WelcomePresenter(DataManager dataManager){
        this.dataManager = dataManager;
    }
    @Override
    public void getWelcomeData() {
        addSubscribe(dataManager.fetchWelcomeInfo()
        .compose(RxUtil.<WelcomeBaen>rxSchedulerHelper())
        .subscribe(new Consumer<WelcomeBaen>() {
            @Override
            public void accept(@NonNull WelcomeBaen welcomeBaen) throws Exception {
                mView.showContent(welcomeBaen);
                Logger.e("respon:___"+welcomeBaen.getImg());

//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    mView.joinMain();
//                }
            }
        },new Consumer<Throwable>(){

            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Logger.e("reeor:___"+throwable.getMessage());
            }
        }));


    }
}
