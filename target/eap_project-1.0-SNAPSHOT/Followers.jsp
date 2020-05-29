<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.Configs.DatabaseConnection" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <title>Followers</title>
</head>
<body>

<div style="height:100px; overflow:auto">
    <table>
<% List<Account> myList = (List<Account>) request.getAttribute("accounts");
    for(int i = 0; i < myList.size();i++){

%>

        <tr>
            <td> <%=myList.get(i) + " is stalking you"%></td>
        </tr>

        <%
            }
        %>

    </table>
</div>

<form method="get" action="/MainPage.jsp">
    <input type="submit" value="Go back">
</form>
</body>
</html>
