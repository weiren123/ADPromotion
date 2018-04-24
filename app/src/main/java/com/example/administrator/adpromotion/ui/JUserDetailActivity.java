package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.JUserContract;
import com.example.administrator.adpromotion.component.ImagesLoader;
import com.example.administrator.adpromotion.model.api.Apis;
import com.example.administrator.adpromotion.presenter.JUserPresenter;

import java.util.Map;

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
    public void showUserInfo(Map params) {
        String sex = (String) params.get("usersex");
        String username = (String) params.get("username");
        String userbirthday = (String) params.get("userbirthday");
        String userage = (String) params.get("userage");
        String useravatar = (String) params.get("useravatar");
        if("1".equals(sex)){
            txSex.setText("男");
        }else {
            txSex.setText("女");
        }
        txNick.setText(username);
        txBirthday.setText(userbirthday);
        String headerimg = Apis.HOST+"static/image/"+useravatar+".jpg";
        ImagesLoader.loadRoundImg(this,headerimg,headIcon);
    }

    @Override
    public void eventSend(final int userId, final int answerId) {
        txSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JUserSendActivity.class);
                intent.putExtra("userid",userId);
                intent.putExtra("answerid",answerId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);

    }

}
