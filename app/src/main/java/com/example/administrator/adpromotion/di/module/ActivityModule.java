package com.example.administrator.adpromotion.di.module;

import android.app.Activity;

import com.example.administrator.adpromotion.di.spoce.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/29.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity =activity;
    }
    @Provides
    @ActivityScope
    public Activity provideActivity(){return mActivity;}
}
