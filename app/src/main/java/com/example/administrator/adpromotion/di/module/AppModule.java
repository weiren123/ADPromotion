package com.example.administrator.adpromotion.di.module;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.model.DataManager;
import com.example.administrator.adpromotion.model.http.HttpHelper;
import com.example.administrator.adpromotion.model.http.RetrofitHelper;

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

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}
