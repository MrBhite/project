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
        <p>Please enter your username , password and checkcode.</p>
        <p>
            <table>
            <tr>
                <td>username:</td>
                <td><input type="text" name="username" value="j2ee" />
            </tr>
            <tr>
                <td>password:</td>
                <td><input type="password" name="password" value="j2ee" />
            </tr>
            <tr>
                <td>checkCode:</td>
                <td><input name="checkCode" type="text" id="checkCode"></td>
            </tr>
            </table>
            <br />
            <br/>

            <img id="checkCodeImg" src="checkcode">
            <a href="#" id="changeImg" >Change</a>
        </p>
        <input type="submit" value="Login">

    </form>
    Need a user name and password?
    <a href="newAccount">Register Now!</a>
</div>
<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "checkcode?"+new Date().getMilliseconds();
    }

</script>

<%@ include file="../common/bottom.jsp"%>