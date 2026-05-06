package com.example.BookMyShowLLD.Entity;

public class Movie {
    String movieId;
    String movieName;
    int movieDuration;

    public Movie(String movieId, String movieName, int movieDuration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
    }

    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
}
