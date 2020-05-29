<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>User Profile</title>
</head>
<body>

<%
%>

<%
    if((int)request.getAttribute("ok") == 0)
        out.println("UserNotFoundException(not an actually exception)! <br/>");
    else {
    Account tempAcc = (Account) request.getAttribute("user");
    out.println(tempAcc + "<br/>");
    int result = (int) request.getAttribute("check");
    if (result == 0) {
    out.println("You are NOT interested in this monster <br/> You are NOT hunted by this user");
%>
    <form method="get" action="/Follow">
        <input type = "hidden" name="acc" value='<%=tempAcc.getID()%>' />
        <input type="submit" value="Hunt them down"> <%="<br/>"%>
<%
    }
        else if (result == 1)  {
            out.println("You are NOT interested in this monster <br/> You are hunted by this user");
%>
        <form method="get" action="/Follow">
            <input type = "hidden" name="acc" value='<%=tempAcc.getID()%>' />
            <input type="submit" value="Hunt them down"> <%="<br/>"%>
                <%
        }
        else if (result == 3) out.println("You are interested in this monster <br/> You are  hunted by this user");
        else out.println("You are interested in this monster <br/> You are NOT hunted by this user");
    }
%>

<br/>
<br/>
<br/>

<form method="get" action="/SeeUsers">
    <input type="submit" value="Go back">

</form>
</body>
</html>
