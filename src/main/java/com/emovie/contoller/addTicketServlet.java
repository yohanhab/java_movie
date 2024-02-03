package com.emovie.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.emovie.db.Provider;

/**
 * Servlet implementation class addTicketServlet
 */
@WebServlet("/AddTicket")
public class addTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTicketServlet() {
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
        response.setContentType("text/html;charset=UTF-8");
        int status = 0 ;
        
       try {
    	   String movie = request.getParameter("movieName");
    	   String user = request.getParameter("email");
    	   String time = request.getParameter("date");
    	   String amount = request.getParameter("paid");
    	   String cinema = request.getParameter("location");
    	   String motime = request.getParameter("time");
    	   String phone = request.getParameter("mobile");
    	   String card = request.getParameter("cardNumber");

		try (Connection connection = Provider.getConnection()) {
		    connection.setAutoCommit(false);

		    try (PreparedStatement pStatement = connection.prepareStatement("INSERT INTO ticket (movieName,email,date,paid,location,time,mobile,cardNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
		        pStatement.setString(1, movie);
		        pStatement.setString(2, user);
		        pStatement.setString(3, time);
		        pStatement.setString(4, amount);
		        pStatement.setString(5, cinema);
		        pStatement.setString(6, motime);
		        pStatement.setString(7, phone);
		        pStatement.setString(8, card);

		        status = pStatement.executeUpdate();
		        connection.commit();
		    } catch (Exception e) {
		        connection.rollback();
		        throw e;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

		
		
		
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
       
       
       if (status > 0) {
		response.sendRedirect("#");
	}
       else {
		response.sendRedirect("movie.html");
	}
	}

}
