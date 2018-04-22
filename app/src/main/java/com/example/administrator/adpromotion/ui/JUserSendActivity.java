package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.JUserSendContract;
import com.example.administrator.adpromotion.model.SendContentBean;
import com.example.administrator.adpromotion.presenter.JUserSendPresenter;

import butterknife.BindView;

public class JUserSendActivity extends BaseActivity<JUserSendPresenter> implements JUserSendContract.View {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.et_conntent)
    EditText etConntent;
    @BindView(R.id.tv_show_title)
    TextView tvShowTitle;
    @BindView(R.id.tv_show_module)
    TextView tvShowModule;
    @BindView(R.id.activity_juser_send)
    RelativeLayout activityJuserSend;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_juser_send;
    }

    @Override
    protected void initData() {
        final int answerId = getIntent().getIntExtra("userid",0);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final String title = "说好的圣诞节";
        final int userId = 1;
        final SendContentBean sendContentBean = new SendContentBean();

        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etConntent.getText().toString();
                sendContentBean.setAnswer_id(answerId);
                sendContentBean.setContent(content);
                sendContentBean.setTitle(title);
                sendContentBean.setUser_id(userId);
                mPresenter.sendQuestionData(sendContentBean);
            }
        });

    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void joinSUser(int id) {
        Intent intent = new Intent(this, SUserListActivity.class);
        intent.putExtra("user_id",id);
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
