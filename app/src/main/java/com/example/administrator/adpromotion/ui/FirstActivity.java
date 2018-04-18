package com.example.administrator.adpromotion.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.FirstContract;
import com.example.administrator.adpromotion.component.GlideImageLoader;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.presenter.FirstPresenter;
import com.example.administrator.adpromotion.ui.adapter.FirsrAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

import butterknife.BindView;

public class FirstActivity extends BaseActivity<FirstPresenter> implements FirstContract.View {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ArrayList titles = new ArrayList<>();
    ArrayList images = new ArrayList<>();
    @Override
    protected int getLayoutView() {
        return R.layout.activity_first;
    }

    @Override
    protected void initData() {
        mPresenter.getFirstData();
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    public void showBanner() {
        images.add(R.mipmap.index_10);
        images.add(R.mipmap.index_11);
        images.add(R.mipmap.index_12);
        titles.add("一");
        titles.add("二");
        titles.add("三");
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void showList(FirstBean firstBean) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirsrAdapter mAdapter = new FirsrAdapter(this,firstBean);
        recyclerView.setAdapter(mAdapter);
    }
}
