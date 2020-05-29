<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inexistent user</title>
</head>
<body>



<% out.println("Emote not found! <br/>"); %>
<br/>
<form method="get" action="/GeneratingMessages">
    <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
    <input type="submit" value="Go back">
</form>
</body>
</html>