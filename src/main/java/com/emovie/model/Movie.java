package com.emovie.model;

public class Movie {
    private String movieId;
    private String movieName;
    private String producer;
    private String director;
    private String cast;
    private String duration;
    private String story;
    private String type;
    private String imageUrl; // URL string for the image

    // Constructors, getters, and setters

    public Movie() {
    }

    public Movie(String movieId, String movieName, String producer, String director, String cast,
                 String duration, String story, String type, String imageUrl) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.producer = producer;
        this.director = director;
        this.cast = cast;
        this.duration = duration;
        this.story = story;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    // Getters and setters

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
