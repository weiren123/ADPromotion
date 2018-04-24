package com.example.administrator.adpromotion.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.SUserAnswerContract;
import com.example.administrator.adpromotion.model.QuestionBean;
import com.example.administrator.adpromotion.model.SUserAnswerBean;
import com.example.administrator.adpromotion.presenter.SUserAnswerPresenter;
import com.example.administrator.adpromotion.ui.adapter.AUserAnswerAdapter;
import com.example.administrator.adpromotion.widget.BottomDialog;

import butterknife.BindView;

public class SUserAnswerActivity extends BaseActivity<SUserAnswerPresenter> implements SUserAnswerContract.View {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_headicon)
    ImageView ivHeadicon;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_creat_time)
    TextView tvCreatTime;
    @BindView(R.id.tv_answer)
    TextView tvAnswer;
    @BindView(R.id.activity_suser_answer)
    RelativeLayout activitySuserAnswer;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private BottomDialog dialog;
    private Button button;
    private AUserAnswerAdapter aUserAnswerAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_suser_answer;
    }

    @Override
    protected void initData() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mPresenter.getPreActivityData(this);
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void showQuestion(final QuestionBean questionBean) {
        tvTitle.setText(questionBean.getTitle());
        tvContent.setText(questionBean.getContent());
        tvCreatTime.setText(questionBean.getCreatTime());

        tvAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v,questionBean);
            }
        });
    }

    @Override
    public void showAnswersList(SUserAnswerBean sUserAnswerBean) {
        aUserAnswerAdapter = new AUserAnswerAdapter(sUserAnswerBean);
        recyclerView.setAdapter(aUserAnswerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void refreshView() {

        if(aUserAnswerAdapter!=null){
            aUserAnswerAdapter.notifyDataSetChanged();
        }
    }

    public void showDialog(View view, final QuestionBean questionBean) {
        dialog = new BottomDialog(this);
        dialog.setContentView(R.layout.dialog);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        dialog.getWindow().setLayout(width,
                height / 2);
        dialog.show();
        button = (Button)dialog.findViewById(R.id.btn);
        final EditText edContent = (EditText)dialog.findViewById(R.id.ed_content);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = edContent.getText().toString();
                mPresenter.addanswerData(questionBean,content);
                dialog.dismiss();
            }
        });
    }
}
