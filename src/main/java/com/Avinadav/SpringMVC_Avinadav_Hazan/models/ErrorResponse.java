package com.Avinadav.SpringMVC_Avinadav_Hazan.models;

public class ErrorResponse {
    private String msg;
    private long timestamp;

    private ErrorResponse(String msg, long timestamp) {
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public static ErrorResponse ofNow(String msg) {
        return new ErrorResponse(msg, System.currentTimeMillis());
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}


