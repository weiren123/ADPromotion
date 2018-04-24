package com.example.administrator.adpromotion.presenter;

import android.app.Activity;

import com.example.administrator.adpromotion.base.RxPresenter;
import com.example.administrator.adpromotion.base.contract.JUserContract;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.utils.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/4/20.
 */

public class JUserPresenter extends RxPresenter<JUserContract.View> implements JUserContract.Presenter {

    private final DataManager mDatamanager;

    @Inject
    public JUserPresenter(DataManager mDatamanager){
        this.mDatamanager = mDatamanager;
    }
    @Override
    public void getJuserDataInfo() {

        addSubscribe(mDatamanager.fetchFirstDataInfo()
        .compose(RxUtil.<FirstBean>rxSchedulerHelper())
        .subscribe(new Consumer<FirstBean>() {
            @Override
            public void accept(@NonNull FirstBean firstBean) throws Exception {
//                mView.showUserInfo(firstBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                mView.showErrorMsg(throwable.getMessage());
            }
        }));
    }

    @Override
    public void getFirsrData(Activity context) {
        int userId = context.getIntent().getIntExtra("userid",0);
        int answerid = context.getIntent().getIntExtra("answerid", 0);
        String userAge = context.getIntent().getStringExtra("userage");
        String userAvatar = context.getIntent().getStringExtra("useravatar");
        String userName = context.getIntent().getStringExtra("username");
        String userSex = context.getIntent().getStringExtra("usersex");
        String userBirthday = context.getIntent().getStringExtra("userbirthday");
        Map params = new HashMap<>();
        params.put("userage",userAge);
        params.put("useravatar",userAvatar);
        params.put("username",userName);
        params.put("userbirthday",userBirthday);
        params.put("usersex",userSex);
        mView.showUserInfo(params);
        mView.eventSend(userId,answerid);
    }
}
