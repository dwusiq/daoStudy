<%--
  Created by IntelliJ IDEA.
  User: wicker
  Date: 2017/6/12
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生管理首页</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
  </head>
  <body>
    <div>
      <a href="views/addPage.jsp">新增</a>
      <a href="views/delPage.jsp">删除</a>
      <a href="views/updatePage.jsp">修改</a>
    </div>
    <hr style="height: 2px;">
    <div>
      <table id="myTable"border="1">

      </table>
    </div>
  <div id="pageDiv"></div>
  </body>
</html>
