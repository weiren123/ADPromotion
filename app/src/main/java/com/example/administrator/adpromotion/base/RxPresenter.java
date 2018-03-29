package com.example.administrator.adpromotion.base;

/**
 * Created by Administrator on 2018/3/28.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void attchView(T view) {
        this.mView =view;
    }

    @Override
    public void detchView() {
        this.mView =null;
    }
}
