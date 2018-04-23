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
import com.example.administrator.adpromotion.base.contract.RegistContract;
import com.example.administrator.adpromotion.presenter.RegistPresenter;

import butterknife.BindView;

import static com.example.administrator.adpromotion.R.id.register_last_login;

public class RegistActivity extends BaseActivity<RegistPresenter> implements RegistContract.View {


    @BindView(R.id.register_back)
    ImageView registerBack;
    @BindView(register_last_login)
    LinearLayout registerLastLogin;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_pswd)
    EditText registerPswd;
    @BindView(R.id.ok_register_pswd)
    EditText okRegisterPswd;
    @BindView(R.id.register_terms_of_service)
    TextView registerTermsOfService;
    @BindView(R.id.register_btn)
    Button registerBtn;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phone = registerPhone.getText().toString();
                final String pwd = registerPswd.getText().toString();
                String okPwd = okRegisterPswd.getText().toString();
                if(!okPwd.equals(pwd)){
                    Toast.makeText(getApplicationContext(),"两次输入的密码不一致！",Toast.LENGTH_SHORT).show();
                }else {
                    mPresenter.registUser(phone,pwd);
                }
            }
        });

        registerLastLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
    public void JoinLogin() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
