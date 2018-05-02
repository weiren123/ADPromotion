package com.example.administrator.adpromotion.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.administrator.adpromotion.di.component.AppComponent;
import com.example.administrator.adpromotion.di.component.DaggerAppComponent;
import com.example.administrator.adpromotion.di.module.AppModule;
import com.orhanobut.logger.Logger;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2018/3/28.
 */

public class App extends Application {

    private static App instance;
    private static AppComponent appComponent;
    private Set<Activity> allActivities;

    public static synchronized App getInstance(){return instance;}

//    static {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化极光
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        String registrationID = JPushInterface.getRegistrationID(getApplicationContext());
        Logger.e("registrationID:"+registrationID);
    }
    @Override
    public void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }


    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if ( allActivities!= null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static AppComponent getAppComponent(){
        if(appComponent==null){
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(instance))
                    .build();
        }
        return appComponent;
    }
}
