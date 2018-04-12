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


@WebServlet("/signup.php")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String conPass = request.getParameter("confirmpassword");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher;
		
		if(!password.equals(conPass)) {
			out.println("<html><body onload=\"alert('Error!!! Password did not match')\"></body></html>");
			dispatcher = request.getRequestDispatcher("/signup.html");
		} else {
			List<String> retValue = Operator.signUp(firstName, lastName, email, password);
			
			if (retValue.get(0).equals("true")) {
				out.println("<html><body onload=\"alert('Registration completed!!! " + retValue.get(1) + "')\"></body></html>");
				dispatcher = request.getRequestDispatcher("/login.html");
			}
			else {
				out.println("<html><body onload=\"alert('Error!!!" + retValue.get(1) + "')\"></body></html>");
				dispatcher = request.getRequestDispatcher("/signup.html");
			}
		}

		dispatcher.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
