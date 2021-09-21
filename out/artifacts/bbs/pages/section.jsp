<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/14
  Time: 下午1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<body>
<div class="container">
    <div class="row">
        <!--路径导航，搜索，注册登陆 -->
        <div class="col-md-4">
            <ol class="breadcrumb">
                <li><a href="/index">Forum</a></li>
                <li class="active">Section</li>
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
    <div class="container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">${sectionName}</div>
            <!-- Table -->
            <table class="table">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>作者</th>
                    <th>发送时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${postList}">
                    <tr>
                        <td><a href="post?postId=${post.postId}">${post.title}</a></td>
                        <td><%=new userDaoImpl().getUserInfoById(pageContext.getAttributesScope("post.userId")).getNickname()%></td>
                        <td>${post.time}</td>
                    </tr>
                </c:forEach>
                </tbody>


            </table>
        </div>
        <ul class="pager">

            <c:if test="${page!=1}">
                <li><a href="/section?sectionId=${sectionId}&page=${page-1}">上一页</a></li>
            </c:if>
            <c:if test="${pageSum!=1}">
                <li><a href="/section?sectionId=${sectionId}&page=${page+1}">下一页</a></li>
            </c:if>
            <h4>当前是第${page}页,共${pageSum}页</h4>

        </ul>

    </div>
</div>
</body>
</html>
