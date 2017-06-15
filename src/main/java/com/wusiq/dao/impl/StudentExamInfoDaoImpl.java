package com.wusiq.dao.impl;

import com.alibaba.fastjson.JSON;
import com.wusiq.dao.StudentExamInfoDao;
import com.wusiq.vo.StudentExamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生考试信息的数据库操作服务实现类
 */
public class StudentExamInfoDaoImpl implements StudentExamInfoDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentExamInfoDaoImpl.class);
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public StudentExamInfoDaoImpl(Connection conn){
        this.conn = conn;
    }

    /**
     * 增
     */
    @Override
    public boolean addExamInfo(StudentExamInfo sei) {
        LOGGER.info("插入学生成绩信息到数据库开始...");
        boolean result = true;
        String sql = "insert into student_exam_info(studentName,studentClass,studentScore,subjectsName)values('%1s','%2s',%3s,'%4s')";
        String sql_format = String.format(sql, sei.getStudentName(),sei.getStudentClass(),sei.getStudentScore(),sei.getSubjectsName());
        LOGGER.info("插入学生成绩信息到数据库sql:{}",sql_format);
        try {
            ps = conn.prepareStatement(sql_format);
            int i = ps.executeUpdate();
            if (i!=1){
                LOGGER.warn("修改用户信息受影响记录数为[{}]",i);
                result = false;
            }
        } catch (SQLException e) {
            LOGGER.error("插入学生成绩信息到数据库失败",e);
        }
        LOGGER.info("插入学生成绩信息到数据库结束.返回参数{}...",result);
        return result;
    }

    /**
     * 删
     */
    @Override
    public boolean delExamInfo(int studentId) {
        LOGGER.info("删除学生成绩信息开始...");
        boolean result = true;
        String sql = "delete from student_exam_info where studentId=%1s";
        String sql_format = String.format(sql,studentId);
        LOGGER.info("删除学生成绩信息sql:{}",sql_format);
        try {
            ps = conn.prepareStatement(sql_format);
            int i =  ps.executeUpdate();
            if (i!=1){
                LOGGER.warn("删除学生成绩信息受影响记录数为[{}]",i);
                result = false;
            }
        } catch (SQLException e) {
            LOGGER.error("从数据库中删除学生成绩信息失败",e);
        }
        LOGGER.info("删除学生成绩信息结束.返回参{}...",result);
        return result;
    }

    /**
     * 改
     */
    @Override
    public boolean updateExamInfo(StudentExamInfo sei) {
        LOGGER.info("修改学生成绩信息开始...");
        boolean result = true;
        String sql = "update student_exam_info set studentName='%1s',studentClass='%2s',studentScore=%3s,subjectsName='%4s' where studentId='%5s'";
        String sql_format = String.format(sql,sei.getStudentName(),sei.getStudentClass(),sei.getStudentScore(),sei.getSubjectsName(),sei.getStudentId());
        LOGGER.info("修改学生成绩信息sql:{}",sql_format);
        try {
            ps = conn.prepareStatement(sql_format);
            int i = ps.executeUpdate();
            if (i!=1){
                LOGGER.warn("修改用户信息受影响记录数为[{}]",i);
                result = false;
            }
        } catch (SQLException e) {
            LOGGER.error("修改学生成绩信息失败",e);
            return result;
        }
        LOGGER.info("修改学生成绩信息结束.返回参{}...",result);
        return result;
    }

    /**
     * 查
     */
    @Override
    public StudentExamInfo queryById(int studentId) {
        LOGGER.info("查询学生成绩信息开始...");
        StudentExamInfo sei = null;
        String sql = "select * from student_exam_info where studentId=%1s";
        String sql_format = String.format(sql, studentId);
        LOGGER.info("查询学生成绩信息sql:{}",sql_format);
        try {
            ps = conn.prepareStatement(sql_format);
            rs = ps.executeQuery();
            if(rs != null){
                sei = new StudentExamInfo();
                sei.setStudentId(rs.getInt("studentId"));
                sei.setStudentName(rs.getString("studentName"));
                sei.setStudentClass(rs.getString("studentClass"));
                sei.setStudentScore(rs.getInt("studentScore"));
                sei.setSubjectsName(rs.getString("subjectsName"));
            }
        } catch (SQLException e) {
            LOGGER.error("查询学生成绩信息失败",e);
        }
    //    LOGGER.info("查询学生成绩信息结束.返回参{}...", sei.toString());
        return sei;
    }

    /**
     * 查列表
     */
    @Override
    public List<StudentExamInfo> queryList(int pageSize, int pageNumber) {
        List<StudentExamInfo> list = null;

        int startRow = pageSize*(pageNumber-1);
        String sql = "select * from student_exam_info limit %1s,%2s";
        String sql_format = String.format(sql,startRow,pageSize);
        LOGGER.info("查询学生成绩信息列表sql:{}",sql_format);
        try {
            ps = conn.prepareStatement(sql_format);
            rs = ps.executeQuery();
            if(rs != null){
                list = new ArrayList<>();
                while (rs.next()) {
                    StudentExamInfo sei = new StudentExamInfo();
                    sei.setStudentId(rs.getInt("studentId"));
                    sei.setStudentName(rs.getString("studentName"));
                    sei.setStudentClass(rs.getString("studentClass"));
                    sei.setStudentScore(rs.getInt("studentScore"));
                    sei.setSubjectsName(rs.getString("subjectsName"));
                    list.add(sei);
                }
                }
        } catch (SQLException e) {
            LOGGER.error("查询学生成绩信息列表失败",e);
        }
        LOGGER.info("从数据库查询到的学生列表信息：{}",list);
        return list;
    }
}
