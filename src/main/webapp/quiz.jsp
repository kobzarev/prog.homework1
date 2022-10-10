<%@ page import="com.kobzariev.prog.homework1.entity.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
    <style>
        p,
        label {
            font: 1rem 'Fira Sans', sans-serif;
        }

        input {
            margin: .4rem;
        }
    </style>
</head>
<body>
<h1>Hi, <%= (String)session.getAttribute("login") %></h1>
<div>
<form method="post" action="quiz">
    <% for (Question item : (List<Question>)session.getAttribute("questions")) { %>
        <fieldset>
            <legend><%= item.getText()%></legend>
            <% for (String s : item.getAnswers()) { %>
                <div>
                    <input type="radio" name="<%= item.getName()%>" id="<%= s%>" value="<%= s%>">
                    <label for="<%= s%>"><%= s%></label>
                </div>
            <% } %>
        </fieldset>
    <% } %>
    <input type="submit" value="Send"/>
</form>
</div>
</body>
</html>
