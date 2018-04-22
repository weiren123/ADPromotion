package com.example.administrator.adpromotion.model;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class FirstBean {


    /**
     * body : [{"age":"16","avatar":"7EBDBD4E5AAB002BCCCA952F737E6DF3","birthday":"1998-06-24","sex":"","userid":1,"username":"admin","usertype":"1"},{"age":"18","avatar":"00218F966B8AD6266209BF82833D85F8","birthday":"1998-07-26","sex":"0","userid":2,"username":"111","usertype":"1"},{"age":"18","avatar":"FEA96BE5F08B3C44948B73944BC23152","birthday":"1994-07-09","sex":"0","userid":3,"username":"admin","usertype":"1"},{"age":"18","avatar":"0C43724A20AE71E105FD96F4DE5F1E4B","birthday":"1991-08-09","sex":"0","userid":4,"username":"qwe","usertype":"1"},{"age":"18","avatar":null,"birthday":"1991-08-09","sex":"0","userid":5,"username":"qweq","usertype":"1"}]
     * code : success
     * msg : 成功
     */

    private String code;
    private String msg;
    /**
     * age : 16
     * avatar : 7EBDBD4E5AAB002BCCCA952F737E6DF3
     * birthday : 1998-06-24
     * sex :
     * userid : 1
     * username : admin
     * usertype : 1
     */

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
        private String age;
        private String avatar;
        private String birthday;
        private String sex;
        private int userid;
        private String username;
        private String usertype;

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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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
