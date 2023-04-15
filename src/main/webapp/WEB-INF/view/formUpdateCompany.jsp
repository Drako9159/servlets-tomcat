<%--
  Created by IntelliJ IDEA.
  User: antonio
  Date: 13/4/2023
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/home" var="linkServletUpdateCompany"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Form</title>
</head>
<body>

<form action="${linkServletUpdateCompany}" method="post">
  <label for="name">Nombre</label>
  <input type="text" id="name" name="name" value="${ company.name }"/>

  <label for="fecha">Fecha</label>
  <input type="text" id="fecha" name="fecha" value="<fmt:formatDate value="${ company.dateApertura }" pattern="dd/MM/yyyy"/>"/>

  <input type="hidden" name="id" value="${ company.id }"/>
  <input type="hidden" name="action" value="update-company"/>

  <input type="submit"/>
</form>
</body>
</html>