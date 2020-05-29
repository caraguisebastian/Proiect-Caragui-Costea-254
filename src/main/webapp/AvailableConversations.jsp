<%@ page import="main.java.Classes.GroupPackage.Group" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>

<div style="height:300px; overflow:auto">
    <table>
        <%   List<Group> myList = (List<Group>) request.getAttribute("groups");
            for(int i = 0; i < myList.size(); i++){
                Group tempGroup = myList.get(i);
        %>

        <tr>
            <td> <%=myList.get(i) + "<br/>"%>
                <form method="Post" action="/GeneratingMessages">
                    <input type = "hidden" name="groupID" value = '<%=tempGroup.getID()%>' />
                <input type="submit" value="Go to"> <br/>
            </form> </td>
        </tr>


        <%
            }
        %>

        <br/>
    </table>
</div>
</table>
</div>
<br/>
<br/>
<br/>
<form method="get" action="/GroupMenu">
    <input type="submit" value="Create a group">
</form>
<br/>
<br/>
<br/>
<form method="get" action="/MainPage.jsp">
    <input type="submit" value="Back to main page">
</form>
</body>
</html>
