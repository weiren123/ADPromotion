package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.LoginContract;
import com.example.administrator.adpromotion.presenter.LoginPresenter;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.login_logo)
    ImageView loginLogo;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwsd)
    EditText loginPwsd;
    @BindView(R.id.login_forget_pswd)
    TextView loginForgetPswd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_next_register)
    LinearLayout loginNextRegister;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = loginPhone.getText().toString();
                String pwd = loginPwsd.getText().toString();

                mPresenter.login(phone, pwd);
            }
        });
        loginNextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void joinMain() {
        Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}