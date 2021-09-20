<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/14
  Time: 下午8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>${post.title}</title>
</head>
<body>
<div class="container">
    <div class="row">
        <!--路径导航，搜索，注册登陆 -->
        <div class="col-md-4">
            <ol class="breadcrumb">
                <li><a href="#">Forum</a></li>
                <li><a href="/section">Section</a> </li>
                <li class="active">${post.title}</li>
            </ol>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input type="text" class="form-control" aria-label="...">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default">Search</button>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="border border-secondary" >
                <p align="right">您尚未<a href="#">登陆</a>|<a href="#">注册</a></p>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">帖子详情</div>
        <div class="panel-body">
            <h3>${post.title}</h3>
            <hr/>
            <h4>${post.content}</h4>
        </div>





    </div>
</div>
</body>
</html>
