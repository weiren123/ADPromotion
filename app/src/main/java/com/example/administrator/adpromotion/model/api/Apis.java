package com.example.administrator.adpromotion.model.api;

import com.example.administrator.adpromotion.model.CommentBean;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.model.SUserAnswerBean;
import com.example.administrator.adpromotion.model.SUserListBean;
import com.example.administrator.adpromotion.model.SendContentBean;
import com.example.administrator.adpromotion.model.UserInfobean;
import com.example.administrator.adpromotion.model.WelcomeBaen;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/4/4.
 */

public interface Apis {
    String HOST = "http://10.63.205.74:5000/";
//    String HOST = "http://192.168.1.105:5000/";
        //192.168.1.104
    @POST("regist/")
    @FormUrlEncoded
    Flowable<WelcomeBaen> getWelcomeInfo(@Field("telephone") String telephone,
                                         @Field("username") String username,
                                         @Field("password1") String password1,
                                        @Field("password2") String password2);
    @GET("userinfo_list/")
    Flowable<FirstBean> getFirstData();
//    JSONObject JSON_OBJECT = new JSONObject();
    @FormUrlEncoded
    @POST("question/")
    Flowable<CommentBean> sendContent(@Field("answer_id") int telephone,
                                      @Field("title") String title,
                                      @Field("content") String content,
                                      @Field("user_id") int user_id);

    @POST("question/")
    Flowable<CommentBean> sendContentData(@Body SendContentBean sendContentBean);
//    @POST("question/")
//    Flowable<CommentBean> sendContent(@Field() SendContentBean sendContentBean);
    @GET("detail/{id}")
    Flowable<SUserListBean> getSUserListData(@Path("id") int id);

    @FormUrlEncoded
    @POST("add_answer/")
    Flowable<CommentBean> addAnswer(@Field("question_id") int questionId,
                                    @Field("answer_content") String content,
                                    @Field("answer_id") int user_id);

    @FormUrlEncoded
    @POST("answers_list/")
    Flowable<SUserAnswerBean> getSUserListAnswerData(@Field("question_id") int questionId,
                                                     @Field("user_id") int user_id);
    @POST("regist/")
    @FormUrlEncoded
    Flowable<CommentBean> registUser(@Field("telephone") String telephone,
                                         @Field("password") String password);

    @POST("login/")
    @FormUrlEncoded
    Flowable<UserInfobean> loginUser(@Field("telephone") String telephone,
                                     @Field("password") String password);
}
