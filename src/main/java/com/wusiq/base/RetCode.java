package com.wusiq.base;

/**
 * 返回错误码的实体类
 */
public class RetCode {
    private int status;//错误码
    private String message;//错误信息

    public RetCode(int status,String message){
        this.status=status;
        this.message=message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
