<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login failed</title>
</head>
<body>


<% out.println("Wrong username/password! Please try again "); %>
<br/>
<form method="get" action="/index.jsp">
    <% out.println("Press here to go back to the log in screen"); %>
    <input type="submit" value="Go back">
</form>
</body>
</html>