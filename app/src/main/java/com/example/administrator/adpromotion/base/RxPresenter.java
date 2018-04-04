package com.example.administrator.adpromotion.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/3/28.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    private CompositeDisposable mCompositeDisposable;

    protected void addSubscribe(Disposable substription){
        if(mCompositeDisposable==null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(substription);
    }
    protected void unSubscribe(){
        if(mCompositeDisposable!=null){
            mCompositeDisposable.clear();
        }
    }
    @Override
    public void attchView(T view) {
        this.mView =view;
    }

    @Override
    public void detchView() {
        this.mView =null;
        unSubscribe();
    }

}
