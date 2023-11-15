<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/11/2023
  Time: 5:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Product Id </th>
        <th>Product Name</th>
        <th>Description</th>
        <th>
            Action
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>
                <a href="/product/delete/${product.productId}">Xóa</a>
                <a href="/product/form-update/${product.productId}">Sửa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
