package com.example.administrator.adpromotion.di.module;

import com.example.administrator.adpromotion.app.App;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/29.
 */
@Module
public class AppModule {
    private App appliction;
    @Inject
    public AppModule(App instance) {
        this.appliction = instance;
    }
    @Provides
    @Singleton
    public App providesApplicationContext(){
        return appliction;
    }
}
