package com.example.shane.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button exerbtn, newsbtn, vidbtn, timerbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);


        exerbtn = (Button) findViewById(R.id.records_button);
        exerbtn.setOnClickListener(this);

        newsbtn = (Button) findViewById(R.id.news_button);
        newsbtn.setOnClickListener(this);

        vidbtn = (Button) findViewById(R.id.recordvid_button);
        vidbtn.setOnClickListener(this);

        timerbtn = (Button) findViewById(R.id.stopwatch_button);
        timerbtn.setOnClickListener(this);



    }
    public void onClick(View v){

        if(v.getId()==R.id.records_button) {

            Intent intent = new Intent(this, ExerciseRecords.class);
            this.startActivity(intent);

        }else if(v.getId()==R.id.news_button) {

            Intent intent = new Intent(this,News.class);
            this.startActivity(intent);

        }else if(v.getId()==R.id.stopwatch_button) {

            Intent intent = new Intent(this, Stopwatch.class);
            this.startActivity(intent);

        }else if(v.getId()==R.id.recordvid_button) {

            Intent intent = new Intent(this, Record.class);
            this.startActivity(intent);
        }

        return ;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return (true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exercise_item:
                Intent intent = new Intent(MainActivity.this, ExerciseRecords.class);
                startActivity(intent);
                Toast.makeText(this, "Exercise Records",Toast.LENGTH_LONG).show();
                break;

            case R.id.stopwatch_item:
                Intent intent1 = new Intent(MainActivity.this,Stopwatch.class);
                startActivity(intent1);
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();
                break;

            case R.id.news_item:
                Intent intent2 = new Intent(MainActivity.this,News.class);
                startActivity(intent2);
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();
                break;


            case R.id.video_item:
                Intent intent3 = new Intent(MainActivity.this,Record.class);
                startActivity(intent3);
                Toast.makeText(this, "Record",Toast.LENGTH_LONG).show();
                break;

            default:
                setContentView(R.layout.activity_main);

        }



        return super.onOptionsItemSelected(item);
    }
}
