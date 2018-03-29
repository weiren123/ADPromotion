package com.example.administrator.adpromotion.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.SupportActivity;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.di.component.ActivityComponent;
import com.example.administrator.adpromotion.di.component.DaggerActivityComponent;
import com.example.administrator.adpromotion.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author
 * Created by Administrator on 2018/3/28.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
    @Inject
    protected T mPresenter;
    private ActivityComponent activityComponent;
    private Unbinder mBind;
    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        mContext = this;
        mBind = ButterKnife.bind(this);
        App.getInstance().addActivity(this);
        initView();
        initData();
    }
    protected  ActivityComponent getActivityComponten(){
        if(activityComponent == null){
            activityComponent = DaggerActivityComponent.builder()
                    .appComponent(App.getAppComponent())
                    .activityModule(getActivityModule())
                    .build();
        }
        return activityComponent;
    }

    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract int getLayoutView();

    protected abstract void initData();

    protected void  initView(){
        initInject();
        if(mPresenter!=null){
            mPresenter.attchView(this);
        }
    }

    protected abstract void initInject();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detchView();
        }
        App.getInstance().removeActivity(this);
        mBind.unbind();
    }

    @Override
    public void showErrorMsg(String msg) {

    }
}
