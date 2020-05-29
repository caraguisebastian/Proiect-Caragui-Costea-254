<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14/05/2019
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>

  <% out.println("Welcome to my MiniMessenger!"); %>
  <br />
  <% out.println("Here you can log in or register if you are new!"); %>
  <br /> <br />
  <% out.println("Log in: "); %>

  <form method="post" action="/VerifyLogIn">
      <% out.println("Username: "); %>
      <input type="text" name="username">
      <br />
      <% out.println("Password: "); %>
      <input type="password" name="password">
      <br/>
      <input type="submit" value="Login">
  </form>

  <br/>

  <% out.println("Or register here: "); %>

  <form method="post" action="/Register">
      <% out.println("Username: "); %>
      <input type="text" name="username">
      <br />
      <% out.println("Password: "); %>
      <input type="password" name="password">
      <br/>
      <% out.println("Nickname: "); %>
      <input type="text" name="nickname">
      <br/>

      <input type="submit" value="Register">
  </form>

  </body>
</html>
