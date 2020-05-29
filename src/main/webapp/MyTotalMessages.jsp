<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Total messages</title>
</head>
<body>

<% out.println("Your number of pigeons sent is: " + request.getAttribute("total"));%>
<br/>
<form method="get" action="/MainPage.jsp">
   <br/>
    <input type="submit" value="Go back">
</form>
</body>
</html>
