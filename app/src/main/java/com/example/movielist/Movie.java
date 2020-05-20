package com.example.movielist;

import androidx.annotation.NonNull;

public class Movie {

    private String name;
    private String genre;
    private String year;
    private String director;


    public Movie() {
        this("Titanik","sadness","1998","Michael Bay");
    }

    public Movie(String name, String genre, String year, String director) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.director = director;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }



}
