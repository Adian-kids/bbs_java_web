
<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/18
  Time: 下午8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>登陆</title>

</head>

<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form class="form-horizontal" role="form" action="login" method="POST">
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email"
                           placeholder="请输入邮箱">
                </div>
            </div>
            <div class="form-group">
                <label for="passwd" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="passwd" name="passwd"
                           placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <br>
                    <button type="submit" class="btn btn-primary">登陆</button>
                </div>
            </div>
        </form>
        <c:if test="${loginResult == 0}">
            <div class="alert alert-danger" role="alert">用户名或密码错误</div>
        </c:if>
        <c:if test="${loginResult == 1}">
            <div class="alert alert-success" role="alert">登陆成功</div>
            <script> window.location.href = "index"</script>
        </c:if>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>
