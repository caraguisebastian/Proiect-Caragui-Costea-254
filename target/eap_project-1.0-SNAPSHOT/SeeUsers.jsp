<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Users</title>
</head>
<body>


<div style="height:300px; overflow:auto">
<table>
    <%
        List<Account> myList = (List<Account>)request.getAttribute("users");
        for ( int i =0; i < myList.size() ; i++) {
    %>

    <tr>
        <td> <%=myList.get(i)%></td>
    </tr>

    <%
        }
    %>

</table>
</div>


<br/>
<br/>
<br/>

<form method="get" action="/CheckUser">
    <% out.println("Who do you want to check upon? Write their username (second column)"); %>
    <br/>
    <input type="text" name="username">
    <br />
    <input type="submit" value="Use magic to search the target">
</form>

<br/>
<br/>
<br/>
<form method="get" action="/MainPage.jsp">
    <input type="submit" value="Go back">

</form>
</body>
</html>
