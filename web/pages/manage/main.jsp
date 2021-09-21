<%--
  Created by IntelliJ IDEA.
  User: adian
  Date: 2021/9/21
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<html>
<body>
<c:if test="${isManager==1}">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">论坛管理</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" action="editForum" ,method="POST">
                            <div class="form-group">
                                <label for="title" class="col-sm-2 control-label">论坛标题</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="title" name="title"
                                           placeholder="论坛标题">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="introduction" class="col-sm-2 control-label">论坛简介</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="introduction" name="introduction"
                                           placeholder="论坛简介">
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
                            <script> window.location.href = "manage"</script>
                        </c:if>

                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">帖子管理</h3>
                    </div>
                    <div class="panel-body">
                        <c:forEach var="post" items="${posts}">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    文章名：<a href="post?postId=${post.postId}">${post.title}</a>&nbsp;&nbsp;&nbsp;
                                    <a href="managerDeletePost?postId=${post.postId}">删除</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <c:if test="${deleteResult == 0}">
                        <div class="alert alert-danger" role="alert">删除失败，请联系管理员</div>
                    </c:if>
                    <c:if test="${deleteResult == 1}">
                        <div class="alert alert-success" role="alert">删除成功</div>
                        <script> window.location.href = "manage"</script>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${isManager != 1 }">
    <div class="container">
        <div class="alert alert-danger">您不是管理员</div>
    </div>
</c:if>
</body>
</html>
