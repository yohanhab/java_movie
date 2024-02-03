<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.emovie.model.Movie" %>

<html>
<head>
    <title>Movie List</title>
    <style>
        .movie-card {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            width: 200px;
            display: inline-block;
            text-align: center;
        }

        .movie-image {
            max-width: 100%;
            max-height: 200px;
        }
    </style>
</head>
<body>
    <h2>Movie List</h2>

    <c:forEach var="movie" items="${movies}">
        <div class="movie-card">
          <img class="movie-image" src="${movie.imageUrl}" alt="${movie.name}"/>
          <p>Name: ${movie.movieName}</p>
          <p>Producer: ${movie.producer}</p>
        </div>
    </c:forEach>
</body>
</html>
