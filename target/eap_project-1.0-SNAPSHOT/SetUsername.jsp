<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<% session.setAttribute("username",request.getAttribute("username"));%>

<form method="get" action="/MainPage.jsp">
    <input type="submit" value="1111">
</form>
</body>
</html>
