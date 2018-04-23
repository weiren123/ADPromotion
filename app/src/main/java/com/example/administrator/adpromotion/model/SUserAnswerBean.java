package com.example.administrator.adpromotion.model;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */

public class SUserAnswerBean {

    /**
     * body : [{"answer_id":2,"content":"去我我我我","create_time":"Wed, 04 Apr 2018 10:47:32 GMT","user_id":1},{"answer_id":2,"content":"轻轻去去去","create_time":"Wed, 04 Apr 2018 10:47:38 GMT","user_id":1},{"answer_id":2,"content":"轻轻去去去","create_time":"Wed, 04 Apr 2018 10:48:30 GMT","user_id":1},{"answer_id":2,"content":"灌灌灌灌","create_time":"Wed, 04 Apr 2018 11:01:51 GMT","user_id":1}]
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
         * answer_id : 2
         * content : 去我我我我
         * create_time : Wed, 04 Apr 2018 10:47:32 GMT
         * user_id : 1
         */

        private int answer_id;
        private String content;
        private String create_time;
        private int user_id;

        public int getAnswer_id() {
            return answer_id;
        }

        public void setAnswer_id(int answer_id) {
            this.answer_id = answer_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    }
}
