package com.wusiq.base.Constants;

import com.wusiq.base.RetCode;

/**
 * 错误信息返回的常量
 * 四位数：首位（0是系统错误，1是用户造成的错误）+三位顺序数
 */
public class ErrConstants {
    /***
     * 系统错误
     */
    public static final RetCode ADD_STUDENT_EXAM_INFO_ERROR = new RetCode(0001,"添加用户信息失败！");

    /***
     * 用户错误
     */
}
