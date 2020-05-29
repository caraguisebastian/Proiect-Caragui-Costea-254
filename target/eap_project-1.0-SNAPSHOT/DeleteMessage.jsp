<%@ page import="main.java.Classes.MessagePackage.Message" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete message</title>
</head>
<body>

<div style="height:300px; overflow:auto">
    <table>
        <%
            List<Message> myList = (List<Message>)request.getAttribute("messages");
            for ( int i =0; i < myList.size() ; i++) {
                Message tempMess = myList.get(i);
        %>

        <tr>
            <td> <%=request.getAttribute("nickname")+ ": " + myList.get(i) + "<br/>"%>
                <form method="Post" action="/DeletingMessage">
                    <input type = "hidden" name="messageID" value = '<%=tempMess.getID()%>' />
                    <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
                    <input type="submit" value="Delete"> <br/>
                </form></td>
        </tr>

        <%
            }
        %>

    </table>
</div>
<br/>
<br/>
<br/>
<form method="Post" action="/GeneratingMessages">
    <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
    <input type="submit" value="Go back">
</form>
</body>
</html>
