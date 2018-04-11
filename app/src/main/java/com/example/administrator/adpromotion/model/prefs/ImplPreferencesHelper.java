package com.example.administrator.adpromotion.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.adpromotion.app.App;
import com.example.administrator.adpromotion.app.Constants;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/4/11.
 */

public class ImplPreferencesHelper implements Preferenceshelper {
    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private final SharedPreferences mSPrefs;
    @Inject
    public ImplPreferencesHelper(){
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void saveLocationLatInfo(float latitude) {
        mSPrefs.edit().putFloat(Constants.LOCATIONLAT,latitude).apply();
    }

    @Override
    public void saveLocationLongtInfo(float longitude) {
        mSPrefs.edit().putFloat(Constants.LOCATIONLONG,longitude).apply();
    }

    @Override
    public float getLocationLatInfo() {
        return mSPrefs.getFloat(Constants.LOCATIONLAT,0);
    }

    @Override
    public float getLocationLongInfo() {
        return mSPrefs.getFloat(Constants.LOCATIONLONG,0);
    }
}
