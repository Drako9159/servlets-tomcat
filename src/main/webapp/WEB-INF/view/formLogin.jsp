<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/home" var="linkServletLogin"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>

<form action="${linkServletLogin}" method="post">
    <label for="login">Login</label>
    <input type="text" id="login" name="login">

    <label for="password">Password</label>
    <input type="password" id="password" name="password">

    <input type="hidden" name="action" value="login"/>

    <input type="submit"/>
</form>
</body>
</html>