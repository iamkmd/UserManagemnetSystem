<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Users, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All</title>
<link rel="stylesheet"  href="css/style.css">
</head>
<body>

<div class="page-container view-all-page"> 
<div class="table-card">
        <div class="table-header">
            <a href="upload" class="add-btn">Add Person</a>
        </div>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p>Error: <%= error %></p>
<%
    }
%>

<%-- message from delete --%>
<% String msg = (String) session.getAttribute("flashMsg");
   if (msg != null) {
       session.removeAttribute("flashMsg"); %>
    <div id="msg" class="msg-success"><%= msg %></div>
<% } %>

<%
    List<Users> list = (List<Users>) request.getAttribute("list");

    if (list != null && !list.isEmpty()) {
%>

<table class="user-table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Image</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <% for (Users u : list) { %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getName() %></td>
                    <td><%= u.getEmail() %></td>
                    <td>
                         <img src="image?id=<%= u.getId() %>" class="table-img"/>
                    </td>
                    <td><a href="delete?id=<%= u.getId() %>" class="icon-link" onclick="return confirmDelete('<%=u.getName()%>')">🗑️</a></td>
                    <td><a href="edit?id=<%= u.getId() %>" class="icon-link">📝</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        <% } else { %>
    <p>No records found.</p>
<% } %>
    </div>
</div>


<script src="JS/app.js"></script>
</body>
</html>