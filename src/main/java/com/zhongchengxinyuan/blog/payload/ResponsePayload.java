package com.zhongchengxinyuan.blog.payload;

public class ResponsePayload {

    private String code = "0000";

    private String message = "success";

    private Object data;

    public String getCode() {
        return code;
    }

    public ResponsePayload setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponsePayload setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponsePayload setData(Object data) {
        this.data = data;
        return this;
    }

    public ResponsePayload() {
    }

    public ResponsePayload(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponsePayload build(){
        return new ResponsePayload();
    }
}
