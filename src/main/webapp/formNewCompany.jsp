<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/home" var="linkServletNewCompany"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>

<form action="${linkServletNewCompany}?action=create-company" method="post">
    <label for="name">Nombre</label>
    <input type="text" id="name" name="name">

    <label for="fecha">Fecha</label>
    <input type="text" id="fecha" name="fecha">

    <input type="submit"/>
</form>
</body>
</html>