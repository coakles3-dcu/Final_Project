package com.example.shane.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.video_menu, menu);

        return (true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exercise_item:
                Intent intent = new Intent(Record.this, ExerciseRecords.class);
                startActivity(intent);
                Toast.makeText(this, "Exercise Records",Toast.LENGTH_LONG).show();



        }
        switch (item.getItemId()){

            case R.id.stopwatch_item:
                Intent intent1 = new Intent(Record.this,Stopwatch.class);
                startActivity(intent1);
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();


        }
        switch (item.getItemId()){


            case R.id.news_item:
                Intent intent2 = new Intent(Record.this,News.class);
                startActivity(intent2);
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();


        }



        return super.onOptionsItemSelected(item);
    }

}
