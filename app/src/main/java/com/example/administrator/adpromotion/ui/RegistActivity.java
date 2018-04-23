package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.app.App;
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
    private boolean isToLogin = false;
    private GestureDetector mGestureDetector;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        addGestureDetectorExit();
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
    protected void onStart() {
        super.onStart();
        if (isToLogin) {
            overridePendingTransition(R.anim.below_in, R.anim.push_top_out);
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (isToLogin) {
            overridePendingTransition(R.anim.below_in, R.anim.push_top_out);
        } else {
            App.getInstance().removeActivity(this);
        }

    }
    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mGestureDetector != null) {
            mGestureDetector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }
    private void addGestureDetectorExit() {

        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                // if (Math.abs(e1.getRawX() - e2.getRawX()) > 250) {
                // LogUtil.print(TAG,"水平方向移动距离过大");
                // return true;
                // }
                if (Math.abs(velocityY) < 100) {
                    return true;
                }

                // 手势向下 down
                if ((e2.getRawY() - e1.getRawY()) > 200) {
                    isToLogin = true;
                    Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                // 手势向上 up
                if ((e1.getRawY() - e2.getRawY()) > 200) {
                    return true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }
}
