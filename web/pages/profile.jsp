<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/20
  Time: 下午1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li class="active">profile</li>
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
                    <p align="right">进入<a href="profile?userId=${userId}">个人主页</a></p>
                </div>
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">发表的帖子</h3>
                </div>
                <div class="panel-body">

                    <c:forEach var="post" items="${posts}">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                文章名：<a href="post?postId=${post.postId}">${post.title}</a>&nbsp;&nbsp;&nbsp;
                                <c:if test="${user.userId==cookieId}">
                                    <a href="deletePost?postId=${post.postId}">删除</a>
                                </c:if>
                            </div>
                        </div>


                    </c:forEach>

                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">个人信息</h3>
                </div>
                <div class="panel-body">
                    <p>昵称:${user.nickname}</p><br>
                    <p>邮箱:${user.email}</p><br>
                    <p>个性签名：${user.signature}</p><br>
                    <p>注册时间:${user.regTime}</p><br>
                    <c:if test="${state == 1}">
                        <c:if test="${user.userId == cookieId}">
                            <a href="edit">
                                <button type="button" class="btn btn-primary">修改信息</button>
                            </a>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${deleteResult == 0}">
        <div class="alert alert-danger" role="alert">删除失败，请联系管理员</div>
    </c:if>
    <c:if test="${deleteResult == 1}">
        <div class="alert alert-success" role="alert">删除成功</div>
        <script> window.location.href = "profile?userId=${userId}"</script>
    </c:if>
</div>

</body>
</html>
