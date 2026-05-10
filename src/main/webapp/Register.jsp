<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<% String msg = (String) request.getAttribute("msg");
   if (msg != null) { %>
    <div id="msg" class="msg-success"><%= msg %></div>
<% } %>

<div class="page-container">
    <h2>Registration</h2>

    <div class="form-area">
        <a href="viewAll" class="view-link">View All</a>

        <form action="upload" method="post" enctype="multipart/form-data">
            <label>Id:</label>
            <input type="text" name="id">

            <label>Name:</label>
            <input type="text" name="name">

            <label>Email:</label>
            <input type="email" name="email">

            <label>Image:</label>
            <input type="file" name="image" id="image">

           
            <div id="previewContainer" style="display:none; margin-bottom:15px;">
            <label>Image Preview:</label>
			<div style="margin-top:10px;">
			<img id="imagePreview" src="#" width="100" height="100" class="img-preview"> 
			</div>
			</div>

            <input type="submit" value="Upload">
        </form>
    </div>
</div>
<script src="JS/app.js"></script>
</body>
</html>