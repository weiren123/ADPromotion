package com.example.administrator.adpromotion.base;

/**
 * Created by Administrator on 2018/3/28.
 */

public interface BasePresenter<T extends BaseView> {

    void  attchView(T view);

    void  detchView();

}
