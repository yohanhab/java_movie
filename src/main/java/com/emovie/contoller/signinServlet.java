package com.emovie.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import com.emovie.db.UserDao;
import com.emovie.model.User;


@WebServlet("/Login")
public class signinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User t=new User();
		t.setEmail(request.getParameter("email"));
		t.setPassword(request.getParameter("password"));
		String type=UserDao.validate(t);
		jakarta.servlet.http.HttpSession ses=request.getSession();
		if(type.equals("user"))
		{
			ses.setAttribute("user",request.getParameter("email"));
			response.sendRedirect("movies.html");
	    }
	 	else if(type.equals("admin"))
		{
			ses.setAttribute("admin",request.getParameter("email"));
			response.sendRedirect("admin.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp?msg=login fails");
		}
	}

}
