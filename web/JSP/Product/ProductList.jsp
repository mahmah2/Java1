<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/format" prefix="fmt" %>--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Our Products</title>
    </head>
    <body>
        <h1>Products</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.description}" /></td>
                    <td><c:out value="${product.getPriceString()}" /></td>
                </tr>
            </c:forEach>
       </table>
    </body>
</html>