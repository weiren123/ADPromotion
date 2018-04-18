package com.example.administrator.adpromotion.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.component.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    private Banner banner;
    ArrayList titles = new ArrayList<>();
    ArrayList images = new ArrayList<>();
//    Integer[] images = {R.mipmap.index_10,R.mipmap.index_11,R.mipmap.index_12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initView();
    }

    private void initView() {

        images.add(R.mipmap.index_10);
        images.add(R.mipmap.index_11);
        images.add(R.mipmap.index_12);
        titles.add("一");
        titles.add("二");
        titles.add("三");
        banner = (Banner) findViewById(R.id.banner);
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
}
