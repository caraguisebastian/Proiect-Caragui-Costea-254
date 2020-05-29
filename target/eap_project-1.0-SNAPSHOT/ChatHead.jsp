<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.Configs.DatabaseConnection" %>
<%@ page import="main.java.Classes.AccountPackage.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.Classes.MessagePackage.Message" %>
<%@ page import="main.java.Classes.MEPackage.ME" %>
<%@ page import="main.java.Repositories.ChainMemes" %>
<%@ page import="main.java.Classes.EmotePackage.Emote" %>
<%@ page import="main.java.Repositories.HasEmote" %>

<html>
<head>
    <title>Chat</title>
</head>
<body>

<div style="height:500px; overflow:auto">
    <table>
        <%   List<Account> accounts = (List<Account>) request.getAttribute("users");
           List<Message> mess = (List<Message>) request.getAttribute("mess");
           List<ME> chain = ChainMemes.getEmotes((String)request.getAttribute("groupID"));
            Emote e = new Emote();
            Message auxMess = new Message();
            for(int i = 0; i < mess.size(); i++){
                Account tempAcc = new Account();
                auxMess = mess.get(i);
                int ok = HasEmote.HE(auxMess,chain);
                for(int j = 0; j < accounts.size(); j++) {
                    tempAcc = accounts.get(j);
                    if (tempAcc.getID() == auxMess.getUserID())
                        break;
                }
                if(auxMess.getReference()==0)
                {
        %>
        <tr>
            <td> <%=tempAcc.getNickname() + ": " + mess.get(i) + "<br/>"%>


        <%      if(ok!=0)
        {
                e = e.getEmote(ok);
        %>
            <image src="images/<%=e.getName()%>" width="50" height="50"/>
                <br/></td></tr>

                <%
        }
                }else{
                    Message refMess = new Message();
                    for(int o = 0; o < mess.size(); o++)
                    {
                        refMess=mess.get(o);
                        if(refMess.getID()==auxMess.getReference()) break;
                    }
                    Account refAccount = new Account();
                    for(int j = 0; j < accounts.size(); j++) {
                        refAccount = accounts.get(j);
                        if (refMess.getUserID() == refAccount.getID())
                            break;
                    }
                    %>
        <tr>
            <td> <%=tempAcc.getNickname() + ": " + mess.get(i) + " *Referrence to the message: " + refAccount.getNickname() + ": " + refMess + "* <br/>"%>

        <%
            if(ok!=0)
        {
            e = e.getEmote(ok);
        %>

            <image src="images/<%=e.getName()%>" width="50" height="50"/>
                <br/></td></tr>

        <%
                    }
        }

            }
        %>

    </table>
</div>
<br/>
<br/>
<br/>
<form method="post" action="/SendMessage">
    <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
    <input type="text" name="message">
    <input type = "hidden" name="messageID" value = '<%=0%>' />
    <br/>
    <input type="submit" value="Send pigeon">
</form>

<br/>
<br/>
<br/>
    <form method="get" action="/PossibleToDeleteMessages">
        <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
        <input type="submit" value="Delete a message">
    </form>
<br/>
<br/>
<br/>
    <form method="get" action="/PossibleToReply">
        <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
        <input type="submit" value="Reply to a message">
    </form>
<br/>
<br/>
<br/>
    <form method="get" action="/WantToReact">
        <input type = "hidden" name="groupID" value = '<%=request.getParameter("groupID")%>' />
        <input type="submit" value="React to a message">
    </form>
<br/>
<br/>
<br/>
    <form method="get" action="/Conversations">
        <input type="submit" value="Go back">
    </form>
</body>
</html>
