package com.example.shane.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Stopwatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);




        Intent intent = new Intent(Stopwatch.this, CountdownTimer.class);
        startActivity(intent);


    }
}
