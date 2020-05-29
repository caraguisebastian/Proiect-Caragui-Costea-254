<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.Configs.DatabaseConnection" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.Classes.MessagePackage.Message" %>

<html>
<head>
    <title>Replying</title>
</head>
<body>

<div style="height:300px; overflow:auto">
    <table>
        <%   List<Account> accounts = (List<Account>) request.getAttribute("accounts");
            List<Message> mess = (List<Message>) request.getAttribute("messages");
            Message auxMess = new Message();
            for(int i = 0; i < mess.size(); i++){
                Account tempAcc = new Account();
                auxMess = mess.get(i);
                for(int j = 0; j < accounts.size(); j++) {
                    tempAcc = accounts.get(j);
                    if (tempAcc.getID() == auxMess.getUserID())
                        break;
                }
        %>
        <tr>
            <td> <%=tempAcc.getNickname() + ": " + mess.get(i) + "<br/>"%>
                <form method="Post" action="/SendMessage">
                    <input type = "hidden" name="messageID" value = '<%=auxMess.getID()%>' />
                    <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
                    <br/>
                    <input type="text" name="message">
                    <input type="submit" value="Reply"> <br/> </form>
            </td>
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
