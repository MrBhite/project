<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/11/3
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>
<%--用户名输入错误警告
<c:if test="${requestScope.errorMsg ne null}">
    <c:out value="${requestScope.errorMsg}"></c:out>
</c:if>
--%>

<div id="Catalog">
    <form action="signOn" method="post">
        <%--用户名输入错误警告--%>
        <p>${requestScope.errorMsg}</p>
        <p>Please enter your username and password.</p>
        <p><input type="text" name="username" value="j2ee" /><br />
            <input type="password" name="password" value="j2ee" /></p>
        <input type="submit" value="Login">
    </form>
    Need a user name and password?
    <a href="#">Register Now!</a>
</div>

<%@ include file="../common/bottom.jsp"%>