<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/11/2023
  Time: 5:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Product</h1>
<f:form modelAttribute="product" action="/product/save/-1" method="post">
    <label>Product Name</label>
    <f:input path="productName"/>
    <br>
    <label>Description</label>
    <f:input path="description"/>
    <br>
    <button type="submit">Add Product</button>
</f:form>
</body>
</html>
