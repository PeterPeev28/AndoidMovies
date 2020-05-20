package com.example.movielist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView writer;
    private TextView genre;
    private TextView year;

    public MovieHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_title);
        writer = itemView.findViewById(R.id.tv_writer);
        genre = itemView.findViewById(R.id.tv_genre);
        year = itemView.findViewById(R.id.tv_year);

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setWriter(String writer) {
        this.writer.setText(writer);
    }

    public void setGenre(String genre) { this.genre.setText(genre); }

    public void setYear(String year) { this.year.setText(year); }

}
