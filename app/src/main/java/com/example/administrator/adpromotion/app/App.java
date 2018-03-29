package com.example.administrator.adpromotion.app;

import android.app.Activity;
import android.app.Application;

import com.example.administrator.adpromotion.di.component.AppComponent;
import com.example.administrator.adpromotion.di.component.DaggerAppComponent;
import com.example.administrator.adpromotion.di.module.AppModule;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/28.
 */

public class App extends Application {

    private static App instance;
    private static AppComponent appComponent;
    private Set<Activity> allActivities;

    public static synchronized App getInstance(){return instance;}
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

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
