<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Most Messages</title>
</head>
<body>

<% out.println("Your favorite group is: " + request.getAttribute("favorite"));%>
<br/>
<form method="get" action="/MainPage.jsp">
    <br/>
    <input type="submit" value="Go back">
</form>
</body>
</html>
