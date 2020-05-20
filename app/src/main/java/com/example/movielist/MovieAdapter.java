package com.example.movielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    private ArrayList<Movie> movies;

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.movie_layout, parent, false);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        final Movie movie = movies.get(position);

        holder.setTitle(movie.getName());
        holder.setWriter(movie.getDirector());
        holder.setGenre(movie.getGenre());
        holder.setYear(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void addMovie (Movie movie) {
        this.movies.add(movie);
        notifyItemChanged(0);
    }
}