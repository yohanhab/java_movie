<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <c:forEach var="movie" items="${movieList}">
        <div class="movie-card">
            <img class="movie-image" src="${movie.imageUrl}" alt="<c:out value="${movie.movieName}"/> Image">
            <p>Movie ID: <c:out value="${movie.movieId}"/></p>
            <p>Movie Name: <c:out value="${movie.movieName}"/></p>
            <p>Producer: <c:out value="${movie.producer}"/></p>
            <!-- Add more movie details as needed -->

            <!-- You can also add links to view more details if necessary -->
            <a href="ViewMovie?movieid=<c:out value="${movie.movieId}"/>">View Details</a>
        </div>
    </c:forEach>
</body>
</html>
