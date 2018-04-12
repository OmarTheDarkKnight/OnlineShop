<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/logo.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Admin Panel</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" style="background: #333;">
      <div class="container">
        <div class="navbar-header">
        	<!-- <img class="nav-logo navbar-text pull-left" src="image/logo.jpg"> -->
        	<h4 style="color:white;" class="navbar-text pull-left">Digital Shop</h4>
          <!--  -->
        </div>
        <div id="navbar">
          <ul class="nav navbar-nav navbar-right">
            <li class="custom-hover"><a style="color:white;" href="adminLogIn.html">Log out <span class="glyphicon glyphicon-log-out"></span>
            		</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container">
		<div style="margin-top:150px;" class="custom-allignment col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<%
			String id = (String)request.getAttribute("id");
			String firstName = (String)request.getAttribute("firstName");
			String lastName = (String)request.getAttribute("lastName");
			String email = (String)request.getAttribute("email");
		%>
			
			<h4>Admin ID : <%out.println(id);%><br>
			First Name : <%out.print(firstName);%><br>
			Last Name : <%out.print(lastName);%><br>
			Email : <%out.print(email);%><br></h4>
		</div>
	</div>


</body>
</html>