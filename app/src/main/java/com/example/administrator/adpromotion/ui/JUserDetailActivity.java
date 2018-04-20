package com.example.administrator.adpromotion.ui;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.JUserContract;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.presenter.JUserPresenter;

import butterknife.BindView;

public class JUserDetailActivity extends BaseActivity<JUserPresenter> implements JUserContract.View {

    @BindView(R.id.head_icon)
    ImageView headIcon;
    @BindView(R.id.user_bg)
    RelativeLayout userBg;
    @BindView(R.id.tx_sex)
    TextView txSex;
    @BindView(R.id.tx_nick)
    TextView txNick;
    @BindView(R.id.tx_birthday)
    TextView txBirthday;
    @BindView(R.id.tx_send)
    TextView txSend;
    @BindView(R.id.activity_juser_detail)
    RelativeLayout activityJuserDetail;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_juser_detail;
    }

    @Override
    protected void initData() {
        mPresenter.getJuserDataInfo();
        mPresenter.getFirsrData(this);
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void showUserInfo(FirstBean firstBean) {
//            txSex.setText(firstBean.getBody().get());
    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);

    }

}
