<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/customJquery.js"></script>
	<script src="js/passMatch.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/logo.css" />
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

    <%
		String id = (String)request.getAttribute("id");
		String firstName = (String)request.getAttribute("firstName");
		String lastName = (String)request.getAttribute("lastName");
		String email = (String)request.getAttribute("email");
		request.setAttribute("id", id);
	%>

    <div class="container">
      <div id="adminDataBox" style="margin-top:150px; border-width: 5px;" class="custom-allignment col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Admin Info</div>
            </div>
            

            <div class="panel-body">
                <div style="margin-bottom: 10px;">
                  <div style="float: left;">
                    Admin ID :
                  </div>
                  <div style="float: right;">
                    <%out.println(id);%>
                  </div>   
              </div>

              <br>

              <div style="margin-bottom: 10px;">
                  <div style="float: left;">
                    First Name :
                  </div>
                  <div style="float: right;">
                    <%out.print(firstName);%>
                  </div>   
              </div>

              <br>

              <div style="margin-bottom: 10px;">
                  <div style="float: left;">
                    Last Name :
                  </div>
                  <div style="float: right;">
                    <%out.print(lastName);%>
                  </div>   
              </div>

              <br>

              <div style="margin-bottom: 10px;">
                  <div style="float: left;">
                    Email :
                  </div>
                  <div style="float: right;">
                    <%out.print(email);%>
                  </div>   
              </div>

              <div style="margin-top:10px" class="form-group">
                <!-- Button -->
                <div class="col-sm-12 controls">
                  <button id="updateButton" type="button" class="btn btn-success">Update Data</button>
                </div>
              </div>
            </div>
        </div>
      </div>

      <div id="updateBox" style="margin-top:150px; border-width: 5px; display: none;" class="custom-allignment col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title">Update Data</div>
          </div>

          <div class="panel-body">
            <form id="updateForm" class="form-horizontal" role="form" action="admin" method="post" style="margin-bottom: 0px">
              <div class="panel-body">
                <div style="margin-bottom: 10px;">
                  <div style="float: left;">
                    <b>Admin ID :</b>
                  </div>
                  <div style="float: right;">
                    <b><%out.println(id);%> </b>
                  </div>   
              </div>

              <br>

              <div style="margin-bottom: 10px;" class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="firstname" type="text" class="form-control" name="fname" value="" placeholder='<%out.print(firstName);%>' >
              </div>

              <div style="margin-bottom: 10px;" class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="lastname" type="text" class="form-control" name="lname" value="" placeholder='<%out.print(lastName);%>' >
              </div>

              <div style="margin-bottom: 20px;" class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                <input id="email" type="text" class="form-control" name="email" value="" placeholder='<%out.print(email);%>' >
              </div>

              <div style="margin-bottom: 20px;" class="input-group">
                <a id="passChangeLink" href="#">Change Password</a>
              </div>

              <!-- PAss CHANGE -->
              <div id="passChangeDiv" style="display: none;">
                <div style="margin-bottom: 10px;" class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input id="oldPass" type="password" class="form-control" name="oldPass" value="" placeholder="Old Password">
                </div>

                <div style="margin-bottom: 10px;" class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input id="password" type="password" class="form-control" name="password" value="" placeholder="New Password">
                </div>
                <div style="margin-bottom: 10px;" class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input id="conPass" type="password" class="form-control" name="conPass" value="" placeholder="Confirm New Password">
                </div>

                <a id='passChangeHideLink' href='#'>Xander Cage</a>

              </div>

              <div style="margin-bottom: 0px; border-width: 5px;" class="form-group">
                <!-- Buttons -->
                <div class="col-sm-12 controls">
                  <!-- Go back Button -->
                  <button id="backButton" type="button" class="btn btn-success pull-left b">Go Back</button>

                  <!-- Update Button -->
                  <button id="upButton" type="submit" class="btn btn-success pull-right">Update</button>
                </div>


            </form>
          </div>
        </div>
      </div>

    </div>


</body>
</html>