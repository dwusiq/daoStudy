<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/6/13
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息添加页面</title>
</head>
<body>
<div>
    <a href="../index.jsp">返回首页</a>
</div>
<div>
    <form action="../StudentExamInfoManage.do" method="get">
        <table border="1">
            <tr>
                <td>学生姓名</td>
                <td><input type="text" name="studentName"></td>
            </tr>
            <tr>
                <td>学生班别</td>
                <td><input type="text" name="studentClass"></td>
            </tr>
            <tr>
                <td>学生成绩</td>
                <td><input type="text" name="studentScore"></td>
            </tr>
            <tr>
                <td>考试科目</td>
                <td><input type="text" name="subjectsName"></td>
            </tr>
            <tr style="display: none"><td><input type="text" name="doSomething" value="add"></td></tr>
        </table>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>