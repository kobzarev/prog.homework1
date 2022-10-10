<%@ page import="com.kobzariev.prog.homework1.entity.Stat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kobzariev.prog.homework1.entity.Option" %><%--
  Created by IntelliJ IDEA.
  User: kobzarev
  Date: 05.10.2022
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<div>
  <a href="quiz">Quiz</a>
  <a href="logout">Logout</a>
</div>
<h1>Hi, <%= (String)session.getAttribute("login") %></h1>
<h3><%= (String)session.getAttribute("login") %> stat:</h3>
<% for (Stat item : (List<Stat>)session.getAttribute("userStat")) { %>
<fieldset>
  <legend><%= item.getQuestionText()%></legend>
  <table>
    <% for (Option option : item.getOptions()) {%>
    <tr>
      <td><%= option.getOption()%></td>
      <td><%= option.getCount()%></td>
    </tr>
    <% } %>
  </table>
</fieldset>
<% } %>
<h3>Total stat:</h3>
<% for (Stat item : (List<Stat>)session.getAttribute("result")) { %>
<fieldset>
  <legend><%= item.getQuestionText()%></legend>
  <table>
    <% for (Option option : item.getOptions()) {%>
    <tr>
      <td><%= option.getOption()%></td>
      <td><%= option.getCount()%></td>
    </tr>
    <% } %>
  </table>
</fieldset>
<% } %>
</body>
</html>
