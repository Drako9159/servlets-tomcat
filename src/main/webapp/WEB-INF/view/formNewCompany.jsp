<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/home" var="linkServletNewCompany"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>
<c:import url="logout-partial.jsp"></c:import>

<form action="${linkServletNewCompany}" method="post">
    <label for="name">Nombre</label>
    <input type="text" id="name" name="name">

    <label for="fecha">Fecha</label>
    <input type="text" id="fecha" name="fecha">

    <input type="hidden" name="action" value="create-company"/>

    <input type="submit"/>
</form>
</body>
</html>