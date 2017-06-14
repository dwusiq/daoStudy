package com.wusiq.dao;

import com.wusiq.dao.impl.StudentExamInfoDaoImpl;

import java.sql.Connection;

/**
 * dao工厂类
 */
public class DaoFactory {
    //获取学生成绩管理服务类的对象
    public static StudentExamInfoDao getStudentExamInfoDaoImpl(Connection conn){
        return new StudentExamInfoDaoImpl(conn);
    }
}
