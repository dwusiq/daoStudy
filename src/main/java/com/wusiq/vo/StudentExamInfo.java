package com.wusiq.vo;

/**
 * 对应数据库的实体类
 */
public class StudentExamInfo {
    private Integer studentId;//学生编号
    private String studentName;//学生姓名
    private String studentClass;//学生班别
    private Integer studentScore;//学生成绩
    private String subjectsName;//考试科目

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Integer getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Integer studentScore) {
        this.studentScore = studentScore;
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(String subjectsName) {
        this.subjectsName = subjectsName;
    }

   /* @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"studentId\":")
                .append(studentId);
        sb.append(",\"studentName\":\"")
                .append(studentName).append('\"');
        sb.append(",\"studentClass\":\"")
                .append(studentClass).append('\"');
        sb.append(",\"studentScore\":")
                .append(studentScore);
        sb.append(",\"subjectsName\":\"")
                .append(subjectsName).append('\"');
        sb.append('}');
        return sb.toString();
    }*/
}
