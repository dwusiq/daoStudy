package com.wusiq.base.baseEntity;

import com.wusiq.base.RetCode;

import java.util.Objects;

/**
 * 返回页面参数的实体类基类
 */
public class BaseResponseEntity {
    private int status;//错误码 0成功 其他失败
    private String message;//错误信息
    private Object data;//返回数据实体
    public BaseResponseEntity(int status){
        this.status=status;
    }
    public BaseResponseEntity(int status,String message){
        this.status=status;
        this.message=message;
    }

    public BaseResponseEntity(int status,String message,Objects obj){
        this.status=status;
        this.message=message;
        this.data = obj;
    }

    public BaseResponseEntity(RetCode retCode){
        this.status = retCode.getStatus();
        this.message = retCode.getMessage();
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
