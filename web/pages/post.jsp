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
                <li><a href="/section">Section</a></li>
                <li class="active">${post.title}</li>
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
    <div class="panel panel-primary">
        <div class="panel-heading">帖子详情</div>
        <div class="panel-body">
            <h3>${post.title}</h3>
            <hr/>
            <h4>${post.content}</h4>
        </div>
    </div>
    <form class="form-horizontal" role="form" action="addReply" method="get">
        <div class="form-group">
            <label>发表评论</label>
            <textarea class="form-control" rows="5" id="content" name="content"></textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block">回复</button>
        </div>
        <div class="form-group">
            <input name="postId" hidden="hidden" value="${post.postId}">
        </div>
    </form>
    <c:forEach var="reply" items="${allReply}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">
                    回复来自<%=new userDaoImpl().getUserInfoById(pageContext.getAttributesScope("userId")).getNickname()%>
                </h3>
            </div>
            <div class="panel-body">
                    ${reply.content}
            </div>
        </div>
    </c:forEach>
    <c:if test="${insertResult == 0}">
        <div class="alert alert-danger" role="alert">评论失败</div>
    </c:if>
    <c:if test="${insertResult == 1}">
        <div class="alert alert-success" role="alert">评论成功</div>
        <script> window.location.href = "post?postId=${postId}"</script>
    </c:if>

</div>
</body>
</html>
