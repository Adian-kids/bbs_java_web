<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/21
  Time: 下午12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <!--路径导航，搜索，注册登陆 -->
        <div class="col-md-4">
            <ol class="breadcrumb">
                <li><a href="#">Forum</a></li>
                <li class="active">addPost</li>
            </ol>
        </div>
        <div class="col-md-4">
            <a href="addPost">
                <button type="button" class="btn btn-primary btn-lg btn-block">发帖</button>
            </a>
        </div>
        <div class="col-md-4">
            <c:if test="${state == 0}">
                <div class="border border-secondary">
                    <p align="right">您尚未<a href="pages/login.jsp">登陆</a>|<a href="pages/register.jsp">注册</a></p>
                </div>
            </c:if>
            <c:if test="${state == 1}">
                <div class="border border-secondary">
                    <p align="right">欢迎${nickname},进入<a href="profile?userId=${userId}">个人主页</a></p>
                </div>
            </c:if>
        </div>
    </div>
    <form class="form-horizontal" role="form" action="addPostAction" method="get">
        <div class="form-group">
            <label>选择版块</label>
            <select class="form-control" name="sectionId">
                <c:forEach var="section" items="${sections}">
                    <option value="${section.sectionId}">${section.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>标题</label>
            <input type="text" class="form-control" placeholder="标题" id="title" name="title">
        </div>

        <div class="form-group">
            <label>正文</label>
            <textarea class="form-control" rows="5" id="content" name="content"></textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block">发帖</button>
        </div>
    </form>
    <c:if test="${insertResult == 0}">
        <div class="alert alert-danger" role="alert">发帖失败，请联系管理员</div>
    </c:if>
    <c:if test="${insertResult == 1}">
        <div class="alert alert-success" role="alert">发布成功</div>
        <script> window.location.href = "index"</script>
    </c:if>
</div>
</body>
</html>
