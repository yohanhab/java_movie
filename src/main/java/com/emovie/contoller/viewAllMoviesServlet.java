package com.emovie.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.emovie.db.Provider;
import com.emovie.model.Movie;

@WebServlet("/MovieList")
public class viewAllMoviesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Movie> movieList = new ArrayList<>();
        
       
        
        
        try(Connection connection = Provider.getConnection()) {
        	String qryString = "Select * from addmovie";
        	try (PreparedStatement pStatement = connection.prepareStatement(qryString)){
				try(ResultSet rs = pStatement.executeQuery()) {
					 while (rs.next()) {
		                    Movie movie = new Movie();
		                    movie.setMovieId(rs.getString("movieid"));
		                    movie.setMovieName(rs.getString("moviename"));
		                    movie.setProducer(rs.getString("producer"));
		                    movie.setDirector(rs.getString("director"));
		                    movie.setCast(rs.getString("cast"));
		                    movie.setDuration(rs.getString("duration"));
		                    movie.setStory(rs.getString("story"));
		                    movie.setType(rs.getString("type"));
		                    movie.setImageUrl(rs.getString("imageurl"));
		                    
		                    movieList.add(movie);
				} 
			} 
			
		} 
        }catch (Exception e) {
		e.printStackTrace();
		}
        request.setAttribute("movies", movieList);
        request.getRequestDispatcher("viewmoviee.jsp").forward(request, response);    
    
    
    }}
           