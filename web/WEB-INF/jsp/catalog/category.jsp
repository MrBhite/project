
<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/11/1
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/top.jsp"%>

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
    Return to Main Menu</stripes:link></div>

<div id="Catalog">

    <h2>${sessionScope.category.name}</h2>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="productt" items="${sessionScope.producttList}">
            <tr>
                <td>
                    <a href="#">${productt.productId}</a>
                </td>
                <td>${productt.name}</td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="../common/bottom.jsp"%>


