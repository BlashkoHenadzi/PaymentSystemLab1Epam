<%@ page import="beans.User" %>
<%@ page import="beans.PaymentCard" %>
<%@ page import="beans.CreditCard" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 28.06.2019
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Out</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<a href="index">Back</a>
<c:out value="{1+5*9}"/>
<table class="striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>CardsCount</th>
    </tr>
    </thead>

    <tbody>
<%
        List<String> lists = new ArrayList<>();
        lists.add("listDom");
        lists.add("listSax");
        lists.add("listStax");
        for (String list :
                lists) {
            List<User> users = (List<User>) request.getAttribute(list);
            if (users != null && !users.isEmpty()) {
                for (User s : users) {
                    System.out.println("<tr>");
                    System.out.println("<td>" + s.getName() + "</td>");
                    System.out.println("<td>" + s.getClientCardsCount() + "</td>");
                    System.out.println("<td>" + s.getSurname() + "</td>";
                    System.out.println("</tr>");
                }
            }
        }