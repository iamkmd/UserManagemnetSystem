<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>

<%
Users u = (Users) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit the User</title>
<link rel="stylesheet"  href="css/style.css">
</head>
<body>

<% String msg = (String) request.getAttribute("msg");
   if (msg != null) { %>
    <div id="msg" class="msg-success"><%= msg %></div>
<% } %>


<div class="page-container">
    <h2>Edit Person</h2>

    <div class="form-area">
        <!-- Reusing the link style from registration -->
       
        <form action="update" method="post" enctype="multipart/form-data">
        <a href="viewAll" class="view-link-btn">View All</a>
            <label>Id:</label>
            <input type="text" name="id" value="<%= u.getId() %>" readonly class="readonly-field">

            <label>Name:</label>
            <input type="text" name="name" value="<%= u.getName() %>">

            <label>Email:</label>
            <input type="text" name="email" value="<%= u.getEmail() %>">

            <label>Change Image:</label>
			<input type="file" name="image" id="image">

			<div id="previewContainer" style="display:none; margin-bottom:15px;">
			<label>New Image Preview:</label>
			<div style="margin-top:10px;">
			<img id="imagePreview" src="#" class="img-preview"  width="100" height="100" class="img-preview">
            </div>
            </div>

			<div class="current-image-section">
			<label>Current Image:</label>
			 <div style="margin-top:10px;">
			<img src="image?id=<%= u.getId() %>" width="100" height="100" class="img-preview">
			</div>
			</div>

            <input type="submit" value="Submit" class="submit-btn">
        </form>
    </div>
</div>
<script src="JS/app.js"></script>
</body>
</html>