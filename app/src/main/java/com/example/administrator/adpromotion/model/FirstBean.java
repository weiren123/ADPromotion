package com.example.administrator.adpromotion.model;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class FirstBean {


    /**
     * body : [{"age":"18","avatar":null,"userid":2,"username":"qqq","usertype":"1"},{"age":"18","avatar":null,"userid":3,"username":"qqq","usertype":"1"},{"age":"18","avatar":null,"userid":4,"username":"qqq","usertype":"1"},{"age":"18","avatar":null,"userid":5,"username":"qqq","usertype":"1"},{"age":"18","avatar":null,"userid":6,"username":"admin","usertype":"1"}]
     * code : success
     * msg : 成功
     */

    private String code;
    private String msg;
    private List<BodyBean> body;

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

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * age : 18
         * avatar : null
         * userid : 2
         * username : qqq
         * usertype : 1
         */

        private String age;
        private Object avatar;
        private int userid;
        private String username;
        private String usertype;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }
    }
}
