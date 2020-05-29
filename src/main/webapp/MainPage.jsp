<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>

<% out.println("The hunt is on"); %>
<% out.println(session.getAttribute("nickname")); %>

<form method="get" action="/Following">
    <input type="submit" value="Your prey">

</form>

    <br/>

<form method="get" action="/Followers">
    <input type="submit" value="Your stalkers">

</form>

<br/>

<form method="get" action="/SeeUsers">
    <input type="submit" value="See all enemies">
</form>

<br/>
<br/>

<form method="get" action="/Conversations">
    <input type="submit" value="Pigeons sent and received">

</form>

<br/>
<br/>
<br/>
<form method="get" action="/TotalMessages">
    <input type="submit" value="See the number of pigeons you sent">
</form>
<br/>
<br/>
<br/>
<form method="get" action="/MostPigeons">
    <input type="submit" value="See where did you sent the most pigeons">
</form>

</body>
</html>
