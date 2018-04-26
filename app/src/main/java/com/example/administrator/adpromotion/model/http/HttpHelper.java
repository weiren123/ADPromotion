package com.example.administrator.adpromotion.model.http;

import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.model.SUserAnswerBean;
import com.example.administrator.adpromotion.model.SUserListBean;
import com.example.administrator.adpromotion.model.SendContentBean;
import com.example.administrator.adpromotion.model.UserInfobean;
import com.example.administrator.adpromotion.model.WelcomeBaen;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2018/4/4.
 */

public interface HttpHelper {

    Flowable<WelcomeBaen> fetchWelcomeInfo(String s1,String s2,String s3,String s4);

    Flowable<FirstBean> fetchFirstDataInfo();

    Flowable<CommentBean> fetchSendData(int s1,String s2,String s3,int s4);

    Flowable<SUserListBean> fetchGetSListData(int id);

    Flowable<CommentBean> fetchaddAnswerData(int s1,String s2,int s3);

    Flowable<SUserAnswerBean> fetchanswerListData(int s1, int s3);

    Flowable<CommentBean> fetchregistUser(String s1, String s3);

    Flowable<UserInfobean> fetchLoginUser(String s1, String s3);

    Flowable<CommentBean> sendContent(SendContentBean sendContentBean);

    Flowable<CommentBean> uploadImg(MultipartBody.Part partMap);
}
