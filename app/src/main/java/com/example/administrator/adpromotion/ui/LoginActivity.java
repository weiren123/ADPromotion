package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.util.Log;
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
    private boolean isRegisterToLogin = false;
    private GestureDetector mGestureDetector ;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        addGestureDetectorExit();
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
    @Override
    protected void onStart() {
        super.onStart();
        if (isRegisterToLogin) {
//            overridePendingTransition(R.anim.push_top_in, R.anim.below_out);
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (isRegisterToLogin) {
//            overridePendingTransition(R.anim.push_top_in, R.anim.below_out);
        }
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
                    Log.e("11111", "手指移动的太慢了");
                    return true;
                }

                // 手势向下 down
                if ((e2.getRawY() - e1.getRawY()) > 200) {
                    return true;
                }
                // 手势向上 up
                if ((e1.getRawY() - e2.getRawY()) > 200) {
                    isRegisterToLogin = true;
                    Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                    startActivity(intent);
//                    BusinessLauncher.getInstance().startForResult("registerPage", new Intent(), 10001);
                    return true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }
}