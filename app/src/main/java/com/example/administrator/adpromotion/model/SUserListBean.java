package com.example.administrator.adpromotion.model;

import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */

public class SUserListBean {


    /**
     * body : [{"answer_id":1,"content":"sssss","create_time":"Sat, 21 Apr 2018 14:30:31 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"sssss","create_time":"Sat, 21 Apr 2018 14:32:55 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"图兔兔","create_time":"Sat, 21 Apr 2018 14:35:13 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"看的出来玩呀","create_time":"Sat, 21 Apr 2018 14:44:25 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"咯哦哦弄","create_time":"Sat, 21 Apr 2018 14:55:57 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"来咯哦罢了咯","create_time":"Sat, 21 Apr 2018 16:12:24 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":2,"content":"咯哦哦弄呃呃呃","create_time":"Sat, 21 Apr 2018 16:14:08 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"哦哦么得","create_time":"Sat, 21 Apr 2018 16:20:54 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"咯哦哦弄","create_time":"Sat, 21 Apr 2018 16:25:26 GMT","title":"说好的圣诞节","user_id":1},{"answer_id":1,"content":"按摩椅也","create_time":"Sat, 21 Apr 2018 22:27:22 GMT","title":"说好的圣诞节","user_id":1}]
     * code : success
     * msg : 成功
     */

    private String code;
    private String msg;
    /**
     * answer_id : 1
     * content : sssss
     * create_time : Sat, 21 Apr 2018 14:30:31 GMT
     * title : 说好的圣诞节
     * user_id : 1
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
        private int answer_id;
        private String content;
        private String create_time;
        private String title;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    }
}
