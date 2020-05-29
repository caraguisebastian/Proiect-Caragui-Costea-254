<%@ page import="main.java.Configs.DatabaseConnection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="main.java.Classes.MessagePackage.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.Classes.EmotePackage.Emote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reacting</title>
</head>
<body>

<% out.println("Write the name of the emote next to the React button <br/>");%>
<div style="height:300px; overflow:auto">
    <table>
        <%
            List<Account> accounts = (List<Account>) request.getAttribute("accounts");
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
                <form method="Post" action="/AddingReact">
                    <input type = "hidden" name="messageID" value = '<%=auxMess.getID()%>' />
                    <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
                    <br/>
                    <input type="text" name="emoteName">
                    <input type="submit" value="React"> <br/> </form>
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
<div style="height:300px; overflow:auto">
<table>
    <%
        List<Emote> emotes = (List<Emote>)request.getAttribute("emotes");
        for(int i = 0 ; i<emotes.size();i++)
        {
            Emote tempEmote =   emotes.get(i);
            out.println(tempEmote.getName());
    %>
<tr>
 <image src="images/<%=tempEmote.getName()%>" width="100" height="100"/>
    <br/>

    <%
        }
 %>
</tr>
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
