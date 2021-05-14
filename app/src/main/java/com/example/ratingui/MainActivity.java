package com.example.ratingui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    public RecyclerView rvRating;

    private RatingAdapter ratingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRating = findViewById(R.id.rv_main);
        rvRating.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rvRating.setLayoutManager(linearLayoutManager);
        RatingVewModel categoryViewModel = new ViewModelProvider(this).get(RatingVewModel.class);
        categoryViewModel.getRatinglistMutableLiveData().observe(this, categorys->{
            if(ratingAdapter==null) {
                ratingAdapter = new RatingAdapter(categorys, MainActivity.this);
                rvRating.setAdapter(ratingAdapter);
            }
            ratingAdapter.notifyDataSetChanged();
        });

    }
}