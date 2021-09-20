<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/8
  Time: 下午9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<body>
<div class="container">
    <div class="row">
        <!--路径导航，搜索，注册登陆 -->
        <div class="col-md-4">
            <ol class="breadcrumb">
                <li><a href="#">Forum</a></li>
                <li class="active">Index</li>
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
                <p align="right">您尚未<a href="pages/login.jsp">登陆</a>|<a href="pages/register.jsp">注册</a></p>
            </div>
        </div>
    </div>
    <!--两个面板 -->
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        分类和版块
                    </h3>
                </div>
                <div class="panel-body">
                    <c:forEach var="classify" items="${classifyList}">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">${classify.name}</h3>
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <c:forEach var="section" items="${sectionList}">
                                        <c:if test="${section.classifyId==classify.classifyId}">
                                            <a href="section?sectionId=${section.sectionId}&page=1" class="list-group-item">${section.name}</a>
                                        </c:if>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <!-- 帖子版块-->
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        最新帖子
                    </h3>
                </div>
                <div class="panel-body">
                    <c:forEach var="post" items="${postList}">
                        <a href="post?postId=${post.postId}" class="list-group-item">${post.title}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
