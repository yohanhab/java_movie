package com.emovie.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.emovie.db.Provider;

@WebServlet("/Addmovie")
public class addMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public addMovieServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int status = 0;

        try {
        

            String movieid = request.getParameter("movieid");
         
            String moviename = request.getParameter("moviename");
            String imageUrl = request.getParameter("imageurl");
            String producer = request.getParameter("producer");
            String director = request.getParameter("director");
            String cast = request.getParameter("cast");
            String duration = request.getParameter("duration");
            String story = request.getParameter("story");
            String type = request.getParameter("type");

            Connection con = Provider.getConnection();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(
                    "insert into addmovie values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, movieid);
            ps.setString(2, moviename);
            ps.setString(3, imageUrl);
            ps.setString(4, producer);
            ps.setString(5, director);
            ps.setString(6, cast);
            ps.setString(7, duration);
            ps.setString(8, story);
            ps.setString(9, type);

            status = ps.executeUpdate();
            con.commit();
            con.close();
            System.out.println("status=" + status);

        } catch (Exception ex) {
            ex.printStackTrace();
            out.println("Error --> " + ex.getMessage());
        }

        if (status > 0) {
            response.sendRedirect("addmovie.jsp?msg=movie added");
        } else {
            response.sendRedirect("addmovie.jsp?msg=you already added this movie");
        }
    }
}
