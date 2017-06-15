package com.wusiq.base.Constants;

import com.wusiq.base.RetCode;

/**
 * 错误信息返回的常量
 * 四位数：首位（1是系统错误，2是用户造成的错误）+三位顺序数
 */
public class ErrConstants {
    /***
     * 系统错误
     */
    public static final RetCode DEL_STUDENT_EXAM_INFO_FAIL = new RetCode(1001,"删除学生成绩信息失败！");


    /***
     * 用户错误
     */

}
