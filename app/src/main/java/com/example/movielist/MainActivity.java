package com.example.movielist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieListener {


    MovieAdapter adapter;
    FloatingActionButton btn;

    ArrayList<Movie> list = new ArrayList<Movie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycle_view);

        list.add(new Movie("The Notebook", "romance, drama", "Nick Cassavetes", "2004"));
        list.add(new Movie("The Last Samurai", "action, drama, war", "Edward Zwick", "2003"));
        list.add(new Movie("Green Book", "biography, comedy, drama ", "Peter Farrelly", "2018"));

        adapter = new MovieAdapter(list);

        recyclerView.setAdapter(adapter);
        // Поставя мениджър на изгледа
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn = findViewById(R.id.floatingActionButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);

                FragmentManager fm = getSupportFragmentManager();
                AddNewMovie editNameDialogFragment = AddNewMovie.newInstance();
                editNameDialogFragment = AddNewMovie.newInstance();
                editNameDialogFragment.show(fm, "add_movie_fragment");
            }
        });


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onFinishAddDialog(Movie movie) {
        adapter.addMovie(movie);
    }
}