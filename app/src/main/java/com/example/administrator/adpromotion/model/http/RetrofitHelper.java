package com.example.administrator.adpromotion.model.http;

import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.model.SUserAnswerBean;
import com.example.administrator.adpromotion.model.SUserListBean;
import com.example.administrator.adpromotion.model.SendContentBean;
import com.example.administrator.adpromotion.model.UserInfobean;
import com.example.administrator.adpromotion.model.WelcomeBaen;
import com.example.administrator.adpromotion.model.api.Apis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/4.
 */

public class RetrofitHelper implements HttpHelper {
    private Apis apis;

    @Inject
    public RetrofitHelper(Apis apis){
        this.apis = apis;
    }

    @Override
    public Flowable<WelcomeBaen> fetchWelcomeInfo(String s1,String s2,String s3,String s4) {
        return apis.getWelcomeInfo(s1,s2,s3,s4);
    }

    @Override
    public Flowable<FirstBean> fetchFirstDataInfo() {
        return apis.getFirstData();
    }

    @Override
    public Flowable<CommentBean> fetchSendData( int s1,String s2,String s3, int s4) {
        return apis.sendContent(s1,s2,s3,s4);
    }

    @Override
    public Flowable<SUserListBean> fetchGetSListData(int id) {
        return apis.getSUserListData(id);
    }

    @Override
    public Flowable<CommentBean> fetchaddAnswerData(int s1,String s2,int s3) {
        return apis.addAnswer(s1,s2,s3);
    }

    @Override
    public Flowable<SUserAnswerBean> fetchanswerListData(int s1, int s3) {
        return apis.getSUserListAnswerData(s1,s3);
    }

    @Override
    public Flowable<CommentBean> fetchregistUser(String s1, String s3) {
        return apis.registUser(s1,s3);
    }

    @Override
    public Flowable<UserInfobean> fetchLoginUser(String s1, String s3) {
        return apis.loginUser(s1,s3);
    }

    @Override
    public Flowable<CommentBean> sendContent(SendContentBean sendContentBean) {
        return apis.sendContentData(sendContentBean);
    }
}
