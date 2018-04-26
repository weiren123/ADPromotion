package com.example.administrator.adpromotion.base.contract;

import com.example.administrator.adpromotion.base.BasePresenter;
import com.example.administrator.adpromotion.base.BaseView;

import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2018/4/26.
 */

public interface HRichContract {
    interface View extends BaseView{
            void showHRichList();
    }
    interface Presenter extends BasePresenter<View>{
            void initHRichData();

            void uploadImg(MultipartBody.Part file);
    }
}
