<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Make a group</title>
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

<form method="Post" action="/CreatingGroup">
    <% out.println("Name of the group: "); %>
    <br/>
    <input type="text" name="groupName">
    <br />
    <br />
    <% out.println("Write the users you want to add to the group(second column, max 10 users)"); %>
    <br />
    <br />
    <input type="text" name="username1">
    <br />
    <input type="text" name="username2">
    <br />
    <input type="text" name="username3">
    <br />
    <input type="text" name="username4">
    <br />
    <input type="text" name="username5">
    <br />
    <input type="text" name="username6">
    <br />
    <input type="text" name="username7">
    <br />
    <input type="text" name="username8">
    <br />
    <input type="text" name="username9">
    <br />
    <input type="submit" value="Create group">
</form>


<br/>
<br/>
<br/>


<br/>
<br/>
<br/>
    <form method="get" action="/Conversations">
        <input type="submit" value="Go back">
    </form>
</body>
</html>
