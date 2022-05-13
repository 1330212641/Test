package com.util;

public class ResponseDemo<T> {
 private int code;
 private T data;
 private String msg;

 public ResponseDemo(int code, String msg){
     this.code=code;
     this.msg=msg;
 }

    public ResponseDemo(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //操作成功
    public static <T> ResponseDemo<T> createBySuccess(int code,T data,String msg){
        System.out.println("测试");
        return new ResponseDemo<T>(code,data,msg);
    }
    //操作失败
    public static <T> ResponseDemo<T> createByFail(int code,String msg){
        System.out.println("测试");
        return new ResponseDemo<T>(code,msg);
    }
}
