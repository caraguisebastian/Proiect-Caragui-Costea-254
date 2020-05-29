<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration complete</title>
</head>
<body>

<% out.println("Registration complete!"); %>
<br/>
<form method="get" action="/index.jsp">
    <% out.println("Press here to go back to the log in screen"); %>
    <input type="submit" value="Go back">
</form>
</body>
</html>
