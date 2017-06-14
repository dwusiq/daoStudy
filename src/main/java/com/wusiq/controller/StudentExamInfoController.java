package com.wusiq.controller;

import com.alibaba.fastjson.JSON;
import com.wusiq.base.baseEntity.BasePageResponseEntity;
import com.wusiq.base.baseEntity.BaseResponseEntity;
import com.wusiq.dao.DaoFactory;
import com.wusiq.db.DbConnFactory;
import com.wusiq.vo.StudentExamInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

/**
 * 学生成绩管理
 */
@WebServlet(name="StudentExamInfoController",urlPatterns="/StudentExamInfoManage.do")
public class StudentExamInfoController extends HttpServlet{
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentExamInfoController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String doSomething = req.getParameter("doSomething");
        if("add".equals(doSomething)){
          addStudentExamInfo(req, resp);
        }
        if("queryList".equals(doSomething)){
             queryList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }




    /**
     * 添加学生成绩信息
     */
    public void addStudentExamInfo(HttpServletRequest request, HttpServletResponse resp){
        LOGGER.info("添加学生成绩信息.开始");
        //返回参数实体类
        BaseResponseEntity rspEntity = new BaseResponseEntity(0);
        String studentName = request.getParameter("studentName");
        String studentClass = request.getParameter("studentClass");
        String subjectsName = request.getParameter("subjectsName");
        String studentScoreStr = request.getParameter("studentScore");
        StudentExamInfo sei = new StudentExamInfo();
        sei.setStudentName(studentName);
        sei.setStudentClass(studentClass);
        sei.setSubjectsName(subjectsName);
        if(StringUtils.isNotEmpty(studentScoreStr)){
            sei.setStudentScore(Integer.valueOf(studentScoreStr));
        }

        //添加学生成绩信息
        boolean addResult = DaoFactory.getStudentExamInfoDaoImpl(DbConnFactory.getMysqlDbC().getConn()).addExamInfo(sei);
        try {
            if(addResult){
                request.getRequestDispatcher("views/successPage.jsp").forward(request,resp);
            }else {
                request.getRequestDispatcher("views/errorPage.jsp").forward(request,resp);
            }
        } catch (ServletException e) {
            LOGGER.error("页面跳转异常",e);
            writeInfo(resp,"页面跳转异常");
        } catch (IOException e) {
            LOGGER.error("页面跳转异常",e);
            writeInfo(resp,"页面跳转异常");
        }
        LOGGER.info("添加学生成绩信息.结束");
    }

    /*查询信息列表*/
    public void queryList(HttpServletRequest req, HttpServletResponse resp){
        LOGGER.info("查询学生成绩信息列表开始...");
        BaseResponseEntity bre = new BaseResponseEntity(0);
        int pageSize = 10;
        int pageNumber = 1;
        String ps = req.getParameter("pageSize");
        String pn = req.getParameter("pageNumber");
        if(StringUtils.isNotEmpty(ps)){
            pageSize = Integer.valueOf(ps);
        }
        if(StringUtils.isNotEmpty(pn)){
            pageNumber = Integer.valueOf(pn);
        }
        List<StudentExamInfo> list = DaoFactory.getStudentExamInfoDaoImpl(DbConnFactory.getMysqlDbC().getConn()).queryList(pageSize,pageNumber);
        if(list != null){
            BasePageResponseEntity<StudentExamInfo> bpre = new BasePageResponseEntity();
            bpre.setPageSize(pageSize);
            bpre.setPageNumber(pageNumber);
            bpre.setTotalRecords(list.size());
            bpre.setList(list);

            bre.setData(bpre);
        }
        String json = null;
        try{
            json = JSON.toJSONString(bre);
        }catch(Exception ex){
            LOGGER.error("查询学生成绩信息列表失败",ex);
        }

        LOGGER.info("查询学生成绩信息列表结束.返回参{}...",json);
        writeInfo(resp,json);
    }
    private void writeInfo(HttpServletResponse resp,String Msg){
        try {
            resp.setCharacterEncoding("UTF-8");
            Writer out = resp.getWriter();
            out.write(Msg);
        } catch (IOException e) {
            LOGGER.error("信息输出失败",e);
        }

    }
}
