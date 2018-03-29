package com.example.administrator.adpromotion.ui;

import android.content.Intent;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.WelcomeContract;
import com.example.administrator.adpromotion.presenter.WelcomePresenter;

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View{

    @Override
    public void showContent() {

    }

    @Override
    public void joinMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initData() {
        mPresenter.getWelcomeData();
    }

    @Override
    protected void initInject() {
       getActivityComponten().inject(this);
    }
}
