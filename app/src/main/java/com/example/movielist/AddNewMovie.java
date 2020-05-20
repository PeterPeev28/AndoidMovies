package com.example.movielist;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class AddNewMovie extends DialogFragment implements View.OnClickListener {

    private EditText title;
    private EditText writer;
    private EditText genre;
    private EditText year;
    private Button add;
    MovieListener listener;


    public static AddNewMovie newInstance() {
        return new AddNewMovie();
    }

    public EditText getTitle() {
        return title;
    }

    public void setTitle(EditText title) {
        this.title = title;
    }

    public EditText getWriter() {
        return writer;
    }

    public void setWriter(EditText writer) {
        this.writer = writer;
    }

    public EditText getGenre() {
        return genre;
    }

    public void setGenre(EditText genre) {
        this.genre = genre;
    }

    public EditText getYear() {
        return year;
    }

    public void setYear(EditText year) {
        this.year = year;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public MovieListener getListener() {
        return listener;
    }

    public void setListener(MovieListener listener) {
        this.listener = listener;
    }

    public AddNewMovie() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        writer = view.findViewById(R.id.writer);
        genre = view.findViewById(R.id.genre);
        year = view.findViewById(R.id.year);

        add = view.findViewById(R.id.button);
        add.setOnClickListener(this);

        try {
            title.requestFocus();
            Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        } catch (Exception e){
            Log.d("error",e.toString());
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {

        Movie movie = new Movie(title.getText().toString(), writer.getText().toString(),genre.getText().toString(),year.getText().toString());

        listener.onFinishAddDialog(movie);

        dismiss();
    }
}
