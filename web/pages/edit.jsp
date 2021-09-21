<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/20
  Time: 下午8:04
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
    <form class="form-horizontal" role="form" action="edit" ,method="POST">
        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">昵称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nickname" name="nickname"
                       placeholder="新的昵称">
            </div>
        </div>
        <div class="form-group">
            <label for="signature" class="col-sm-2 control-label">个性签名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="signature" name="signature"
                       placeholder="新的签名">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">确认修改</button>
            </div>
        </div>
    </form>
    <c:if test="${updateResult == 0}">
        <div class="alert alert-danger" role="alert">更改失败</div>
    </c:if>
    <c:if test="${updateResult == 1}">
        <div class="alert alert-success" role="alert">更改成功</div>
        <script> window.location.href = "profile?userId=${userId}"</script>
    </c:if>

</div>
</body>
</html>
