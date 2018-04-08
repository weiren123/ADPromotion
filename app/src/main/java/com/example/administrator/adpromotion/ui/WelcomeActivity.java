package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.WelcomeContract;
import com.example.administrator.adpromotion.component.ImageLoader;
import com.example.administrator.adpromotion.model.WelcomeBaen;
import com.example.administrator.adpromotion.presenter.WelcomePresenter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {


    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    public void showContent(WelcomeBaen welcomeBaen) {
        String str_img = welcomeBaen.getImg();
        String img = str_img.split("'")[1];
        Logger.d(img);
        ImageLoader.loadimg(this, img, imageView);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
