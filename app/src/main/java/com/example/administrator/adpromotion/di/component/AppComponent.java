package com.example.administrator.adpromotion.di.component;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/28.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context
}
