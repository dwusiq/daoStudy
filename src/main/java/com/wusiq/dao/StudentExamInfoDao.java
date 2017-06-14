package com.wusiq.dao;

import com.wusiq.vo.StudentExamInfo;

import java.util.List;

/**
 * 学生考试信息的数据库操作服务类
 */
public interface StudentExamInfoDao {
    //添加学生考试成绩信息
    boolean addExamInfo(StudentExamInfo sei);
    //删除学生考试成绩信息
    boolean delExamInfo(int studentId);
    //修改学生考试成绩信息
    boolean updateExamInfo(StudentExamInfo sei);
    //查询单条学生考试成绩信息
    StudentExamInfo queryById(int studentId);
    //查询学生考试成绩列表
    List<StudentExamInfo> queryList(int pageSize,int pageNumber);

}
