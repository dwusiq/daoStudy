<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/6/15
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../js/updatePage.js"></script>
</head>
<body>
<div>
    <a href="../index.jsp">返回首页</a>
</div>
<hr style="height: 2px;">
<div>
    请输入需要修改的编号：<input type="text" id="studentId"/>
    <button onclick="queryInfo()">查询</button>
</div>

<div>
    <form action="/daoStudy/StudentExamInfoManage.do" method="get">
        <table border="1">
            <tr>
                <td>编号</td>
                <td><input type="text" name="studentId" id="student_id"></td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><input type="text" name="studentName" id="studentName"></td>
            </tr>
            <tr>
                <td>学生班别</td>
                <td><input type="text" name="studentClass" id="studentClass"></td>
            </tr>
            <tr>
                <td>学生成绩</td>
                <td><input type="text" name="studentScore" id="studentScore"></td>
            </tr>
            <tr>
                <td>考试科目</td>
                <td><input type="text" name="subjectsName" id="subjectsName"></td>
            </tr>
            <tr style="display: none"><td><input type="text" name="doSomething" value="updateInfo"></td></tr>
        </table>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
