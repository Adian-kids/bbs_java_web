<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/11
  Time: 下午2:46
  To change this template use File | Settings | File Templates.
--%>
<%@  page import="bbs.dao.impl.*,bbs.entity.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bbs.entity.Forum" %>
<%@ page import="bbs.entity.Classify" %>
<%@ page import="java.lang.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--获取论坛基本信息，name,introduction,createDate-->
<%
    forumDaoImpl dao = new forumDaoImpl();
    Forum forum = dao.getForumInfo();
%>
<html>
<head>
    <title><%=forum.getName() %>
    </title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <div class="page-header">
        <div class="container">
        <h1><%=forum.getName()%><small><%=forum.getIntroduction()%>
        </small></h1>
        </div>
    </div>

</head>
</html>

