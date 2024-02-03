package com.emovie.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.emovie.db.Provider;


@WebServlet("/Updatemovie")
@MultipartConfig
public class updateMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public updateMovieServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int status = 0;

        try {
            // Parse request with Jakarta EE MultipartConfig
            Part filePart = request.getPart("uploadimage"); // "uploadimage" should be the name of your file input field

            String movieid = request.getParameter("movieid");
            String moviename = request.getParameter("moviename");
            String producer = request.getParameter("producer");
            String director = request.getParameter("director");
            String cast = request.getParameter("cast");
            String duration = request.getParameter("duration");
            String story = request.getParameter("story");
            String type = request.getParameter("type");

            // Connect to Oracle
            Connection con = Provider.getConnection();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement("update addmovie set moviename=?, file=?, producer=?, director=?, cast=?, duration=?, story=?, type=? where movieid=?");

            ps.setString(1, moviename);

            if (filePart != null && filePart.getSize() > 0) {
                ps.setBinaryStream(2, filePart.getInputStream(), (int) filePart.getSize());
            } else {
                // Handle case where no file is provided
                // You may want to set this to null or a default value based on your requirements
                ps.setBinaryStream(2, null, 0);
            }

            ps.setString(3, producer);
            ps.setString(4, director);
            ps.setString(5, cast);
            ps.setString(6, duration);
            ps.setString(7, story);
            ps.setString(8, type);
            ps.setString(9, movieid);

            status = ps.executeUpdate();
            con.commit();
            con.close();
            System.out.println("status=" + status);

        } catch (Exception ex) {
            ex.printStackTrace();
            out.println("Error --> " + ex.getMessage());
        }

        if (status > 0) {
//            response.sendRedirect("updatemovie.jsp?msg=movie updated");
            response.sendRedirect("viewmovie.jsp?msg=movie updated");
        } else {
            response.sendRedirect("updatemovie.jsp?msg=movie not found");
        }
    }
}
