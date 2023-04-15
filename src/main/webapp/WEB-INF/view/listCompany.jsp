<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.alura.gerenciador.modelo.Company" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/home" var="linkServletActionCompany"/>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: antonio
  Date: 13/4/2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<c:if test="${not empty company}">
    <h2>Empresa ${company} registrada! <br/></h2>
</c:if>

<h2>List Companys:</h2>

<ul>

    <c:forEach items="${companys}" var="company">
        <li>${ company.name } - <fmt:formatDate value="${ company.dateApertura }" pattern="dd/MM/yyyy"/></li>
        <a href="${linkServletActionCompany}?action=delete-company&id=${company.id}">delete</a>
        <a href="${linkServletActionCompany}?action=show-company&id=${company.id}">update</a>
    </c:forEach>

</ul>
<h2>Another verion</h2>
<ul>

    <% List<Company> list = (List<Company>) request.getAttribute("companys"); %>
    <% for (Company company : list) { %>
    <li><%= company.getName() %>
    </li>
    <% } %>

</ul>
</body>
</html>
