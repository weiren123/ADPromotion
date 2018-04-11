package com.example.administrator.adpromotion.model.prefs;

/**
 * Created by Administrator on 2018/4/11.
 */

public interface Preferenceshelper {
    void saveLocationLatInfo(float latitude);
    void saveLocationLongtInfo(float longitude);
    float getLocationLatInfo();
    float getLocationLongInfo();
}
