<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/11
  Time: 下午2:46
  To change this template use File | Settings | File Templates.
--%>
<%@  page import="bbs.dao.impl.forumDaoImpl,bbs.entity.Forum" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bbs.entity.Forum" %>
<!--获取论坛基本信息，name,introduction,createDate-->
<%
    forumDaoImpl dao = new forumDaoImpl();
    Forum forum =  dao.getForumInfo();
%>
<html>
<head>
    <title><%=forum.getName() %></title>
</head>
<body>
    <h1><%=forum.getIntroduction()%></h1>
    <h2><%=forum.getCreateDate()%></h2>
</body>
</html>

