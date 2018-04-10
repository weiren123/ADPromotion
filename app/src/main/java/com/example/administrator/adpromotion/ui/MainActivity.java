package com.example.administrator.adpromotion.ui;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.MainContract;
import com.example.administrator.adpromotion.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initInject() {

    }

    @Override
    public void showUpdateDialog(String versionContent) {

    }
}
