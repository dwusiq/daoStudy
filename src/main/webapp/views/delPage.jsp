<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/6/15
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生成绩信息页面</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../js/delPage.js"></script>
</head>
<body>
<div>
    <a href="../index.jsp">返回首页</a>
</div>
<hr style="height: 2px;">
<div>
    请输入需要删除的编号：<input type="text" id="studentId"/>
    <button onclick="delInfo()">删除</button>
</div>
</body>
</html>
