<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failed to register</title>
</head>
<body>



<% out.println("Registration failed! The username you entered is already being used by someone else!"); %>
<br/>
<form method="get" action="/index.jsp">
    <% out.println("Press here to go back to the registration screen"); %>
    <input type="submit" value="Go back">
</form>
</body>
</html>