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


@WebServlet("/adminLogIn.php")
public class AdminLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adminID = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher;
		
		List<String> retValue = Operator.adminLogIn(adminID, password);
		
		if (retValue.get(0).equals("true")) {
			request.setAttribute("id", retValue.get(1));
			request.setAttribute("firstName", retValue.get(2));
			request.setAttribute("lastName", retValue.get(3));
			request.setAttribute("email", retValue.get(4));
			
			dispatcher = request.getRequestDispatcher("/adminHome.jsp");
		}
		else {
			out.println("<html><body onload=\"alert('Error!!!" + retValue.get(1) + "')\"></body></html>");
			dispatcher = request.getRequestDispatcher("/adminLogIn.html");
		}

		dispatcher.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
