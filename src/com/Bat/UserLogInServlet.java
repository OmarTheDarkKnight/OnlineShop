package com.Bat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userLogIn.php")
public class UserLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adminID = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher;
		
		List<String> retValue = Operator.userLogIn(adminID, password);
		
		if (retValue.get(0).equals("true")) {
			dispatcher = request.getRequestDispatcher("/home.html");
		}
		else {
			out.println("<html><body onload=\"alert('Error!!!" + retValue.get(1) + "')\"></body></html>");
			dispatcher = request.getRequestDispatcher("/login.html");
		}

		dispatcher.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
