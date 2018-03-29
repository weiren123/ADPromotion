package com.example.administrator.adpromotion.di.component;


import android.app.Activity;

import com.example.administrator.adpromotion.di.module.ActivityModule;
import com.example.administrator.adpromotion.di.spoce.ActivityScope;
import com.example.administrator.adpromotion.ui.WelcomeActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/29.
 */

@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
    void inject(WelcomeActivity welcomeActivity);
}
