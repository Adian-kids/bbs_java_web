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
    <div class="jumbotron">
        <h1>${post.title}</h1>
        <hr/>
        <p>${post.content}</p>

    </div>
</div>
</body>
</html>
