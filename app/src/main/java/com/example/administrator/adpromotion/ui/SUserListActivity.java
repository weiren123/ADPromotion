package com.example.administrator.adpromotion.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.SUserListContract;
import com.example.administrator.adpromotion.model.SUserListBean;
import com.example.administrator.adpromotion.presenter.SUserListPresenter;
import com.example.administrator.adpromotion.ui.adapter.SUserListAdapter;
import com.example.administrator.adpromotion.ui.comment.OnItemClickListener;
import com.example.administrator.adpromotion.ui.comment.RecycleViewDivider;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

public class SUserListActivity extends BaseActivity<SUserListPresenter> implements SUserListContract.View {


    @BindView(R.id.rc_view)
    RecyclerView rcView;
    @BindView(R.id.activity_suser_list)
    RelativeLayout activitySuserList;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_suser_list;
    }

    @Override
    protected void initData() {
        int user_id = getIntent().getIntExtra("user_id", 0);
        Logger.e("user_id:"+user_id);
        mPresenter.getSuserData(user_id);
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }


    @Override
    public void showList(final SUserListBean sUserListBean) {
        SUserListAdapter sUserListAdapter = new SUserListAdapter(sUserListBean);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setAdapter(sUserListAdapter);
        rcView.addItemDecoration(new RecycleViewDivider(this,LinearLayoutManager.HORIZONTAL));
        sUserListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), SUserAnswerActivity.class);
                intent.putExtra("create_time",sUserListBean.getBody().get(position).getCreate_time());
                intent.putExtra("content",sUserListBean.getBody().get(position).getContent());
                intent.putExtra("title",sUserListBean.getBody().get(position).getTitle());
                intent.putExtra("answer_id",sUserListBean.getBody().get(position).getAnswer_id());
                intent.putExtra("user_id",sUserListBean.getBody().get(position).getUser_id());
                startActivity(intent);
            }
        });
    }
}
