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

/**
 * Servlet implementation class adminUpdateServlet
 */
@WebServlet("/adminUpdate.php")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String oldPass = request.getParameter("oldPass");
		String password = request.getParameter("password");
		String conPass = request.getParameter("conPass");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(password == conPass) {
			List<String> retValue = Operator.adminUpdate(id, firstName, lastName, email, oldPass, password);
			if (retValue.get(0).equals("true")) {
				request.setAttribute("id", retValue.get(1));
				request.setAttribute("firstName", retValue.get(2));
				request.setAttribute("lastName", retValue.get(3));
				request.setAttribute("email", retValue.get(4));
			}
		}
		else {
			out.println("<html><body onload=\"alert('Error!!! Passwords did not Match!')\"></body></html>");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
		dispatcher.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
