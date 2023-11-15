<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/11/2023
  Time: 6:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Product</h1>
<f:form action="/product/save/${product.productId}" method="post" modelAttribute="product">
    <label>Product Name</label>
    <f:input path="productName" value="${product.productName}" />
    <br>
    <label>Description</label>
    <f:input path="description" value="${product.description}"/>
    <br>
    <button type="submit">Update Product</button>
</f:form>
</body>
</html>