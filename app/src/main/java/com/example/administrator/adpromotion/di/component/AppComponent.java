package com.example.administrator.adpromotion.di.component;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.di.module.AppModule;
import com.example.administrator.adpromotion.di.module.HttpModule;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/28.
 */

@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类
}
