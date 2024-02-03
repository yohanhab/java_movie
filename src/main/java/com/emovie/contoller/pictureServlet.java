package com.emovie.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.emovie.db.Provider;

/**
 * Servlet implementation class pictureServlet
 */
@WebServlet("/DisplayPhotoServlet")
public class pictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        
    	        try {
    	            Connection con = Provider.getConnection();
    	            PreparedStatement ps = con.prepareStatement("select file from addmovie where movieid = ?");
    	            String id = request.getParameter("id");
    	            ps.setString(1,id);
    	            ResultSet rs = ps.executeQuery();
    	            rs.next();
    	            Blob  b = rs.getBlob("movieimg");
    	            response.setContentType("image/png");
    	            response.setContentLength( (int) b.length());
    	            InputStream is = b.getBinaryStream();
    	            OutputStream os = response.getOutputStream();
    	            byte buf[] = new byte[(int) b.length()];
    	            buf=b.getBytes(1, (int) b.length());
    	            os.write(buf);
    	            os.close();
    	        }
    	        catch(Exception ex) {
    	             System.out.println(ex.getMessage());
    	        }
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
		doGet(request, response);
	}

}
