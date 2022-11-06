
<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/11/1
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <h2>${sessionScope.category.name}</h2>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.producttList}">
            <tr>
                <td><a href="product?productId=${product.productId}">${product.productId}</a></td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
    </table>

</div>


<%@ include file="../common/bottom.jsp"%>


