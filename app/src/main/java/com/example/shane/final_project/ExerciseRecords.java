package com.example.shane.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ExerciseRecords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_records);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.exercise_menu, menu);

        return (true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){

            case R.id.stopwatch_item:
                Intent intent1 = new Intent(ExerciseRecords.this,Stopwatch.class);
                startActivity(intent1);
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();


        }
        switch (item.getItemId()){


            case R.id.news_item:
                Intent intent2 = new Intent(ExerciseRecords.this,News.class);
                startActivity(intent2);
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();


        }
        switch (item.getItemId()){


            case R.id.video_item:
                Intent intent3 = new Intent(ExerciseRecords.this,Record.class);
                startActivity(intent3);
                Toast.makeText(this, "Record",Toast.LENGTH_LONG).show();

        }



        return super.onOptionsItemSelected(item);
    }
}
