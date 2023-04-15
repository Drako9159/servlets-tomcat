<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<c:import url="logout-partial.jsp"></c:import>

<%
    String company = (String)(request.getAttribute("company"));
    System.out.println(company);
%>

<c:if test="${not empty company}">
<h2>La empresa es ${company}!</h2>
</c:if>
<c:if test="${empty company}">
    <h2>Ninguna empresa registrada!</h2>
</c:if>


</body>
</html>