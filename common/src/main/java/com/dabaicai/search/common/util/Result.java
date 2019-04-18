package com.dabaicai.search.common.util;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = -1586118647101027089L;


    private String message;
    private Object object;
    private int code;


    public Result() {
    }

    public Result(int code,String message,Object object){
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


}
