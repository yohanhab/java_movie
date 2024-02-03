package com.emovie.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.emovie.db.UserDao;
import com.emovie.model.User;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/Register")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User u=new User();
		u.setName(request.getParameter("name"));
		u.setEmail(request.getParameter("email"));
		u.setMobile(request.getParameter("mobile"));
		u.setPassword(request.getParameter("password"));
		u.setType("user");
		System.out.println(request.getParameter("name"));
		int status=UserDao.save(u);
		if(status>0)
		{
			response.sendRedirect("index.jsp?msg1= Registration success");
		}
		else
		{
			response.sendRedirect("index.jsp?msg2=Registration fails");
		}
	}

}
