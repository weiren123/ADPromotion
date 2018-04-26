package com.example.administrator.adpromotion.model;

import com.example.administrator.adpromotion.model.http.HttpHelper;
import com.example.administrator.adpromotion.model.prefs.Preferenceshelper;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2018/4/4.
 */

public class DataManager implements HttpHelper,Preferenceshelper {
    Preferenceshelper preferencesHeller;
    HttpHelper httpHelper;
    public DataManager(HttpHelper httpHelper,Preferenceshelper preferencesHeller){
        this.httpHelper = httpHelper;
        this.preferencesHeller = preferencesHeller;
    }

    @Override
    public Flowable<WelcomeBaen> fetchWelcomeInfo(String s1,String s2,String s3,String s4) {
        return httpHelper.fetchWelcomeInfo(s1,s2,s3,s4);
    }

    @Override
    public Flowable<FirstBean> fetchFirstDataInfo() {
        return httpHelper.fetchFirstDataInfo();
    }

    @Override
    public Flowable<CommentBean> fetchSendData(int s1,String s2,String s3,int s4) {
        return httpHelper.fetchSendData(s1,s2,s3,s4);
    }

    @Override
    public Flowable<SUserListBean> fetchGetSListData(int id) {
        return httpHelper.fetchGetSListData(id);
    }

    @Override
    public Flowable<CommentBean> fetchaddAnswerData(int s1, String s2, int s3) {
        return httpHelper.fetchaddAnswerData(s1,s2,s3);
    }

    @Override
    public Flowable<SUserAnswerBean> fetchanswerListData(int s1, int s3) {
        return httpHelper.fetchanswerListData(s1,s3);
    }

    @Override
    public Flowable<CommentBean> fetchregistUser(String s1, String s3) {
        return httpHelper.fetchregistUser(s1,s3);
    }

    @Override
    public Flowable<UserInfobean> fetchLoginUser(String s1, String s3) {
        return httpHelper.fetchLoginUser(s1,s3);
    }

    @Override
    public Flowable<CommentBean> sendContent(SendContentBean sendContentBean) {
        return httpHelper.sendContent(sendContentBean);
    }

    @Override
    public Flowable<CommentBean> uploadImg(MultipartBody.Part file) {
        return httpHelper.uploadImg(file);
    }

    @Override
    public void saveLocationLatInfo(float latitude) {
        preferencesHeller.saveLocationLatInfo(latitude);
    }

    @Override
    public void saveLocationLongtInfo(float longitude) {
        preferencesHeller.saveLocationLongtInfo(longitude);
    }

    @Override
    public float getLocationLatInfo() {
        return preferencesHeller.getLocationLatInfo();
    }

    @Override
    public float getLocationLongInfo() {
        return preferencesHeller.getLocationLongInfo();
    }
}
