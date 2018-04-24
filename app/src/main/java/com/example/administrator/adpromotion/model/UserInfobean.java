package com.example.administrator.adpromotion.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/24.
 */

public class UserInfobean  implements Serializable{

    /**
     * body : {"age":"18","avatar":"F0B65DE59A670836204589F5B876353C","birthday":"","user_id":5,"username":"qqq","usertypr":"1"}
     * code : success
     * msg : 登陆成功!
     */

    private BodyBean body;
    private String code;
    private String msg;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class BodyBean implements Serializable{
        /**
         * age : 18
         * avatar : F0B65DE59A670836204589F5B876353C
         * birthday :
         * user_id : 5
         * username : qqq
         * usertypr : 1
         */

        private String age;
        private String avatar;
        private String birthday;
        private int user_id;
        private String username;
        private String usertypr;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsertypr() {
            return usertypr;
        }

        public void setUsertypr(String usertypr) {
            this.usertypr = usertypr;
        }
    }
}
