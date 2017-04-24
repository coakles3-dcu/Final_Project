package com.example.shane.final_project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Stopwatch extends AppCompatActivity {




    private final int REFRESH_RATE = 1000;

    private int time = 0;
    // private boolean stopped = false;
    private boolean running;
    //private boolean stopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);



        updateTimer();

    }


    public void startClick (View view){


        running= true;
        showStopButton();
       /* if(stopped){
            startTime = System.currentTimeMillis() - elapsedTime;

        }
        else{

            startTime = System.currentTimeMillis();
        }

       /* mHandler.removeCallbacks(startTimer);
        mHandler.postDelayed(startTimer, 0);*/
    }

    public void stopClick (View view){
        running=false;
        hideStopButton();
        // mHandler.removeCallbacks(startTimer);
        //stopped = true;
    }


    public void resetClick (View view){

        running = false;
        //stopped = false;
        time = 0;
    }


    private void showStopButton(){

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.GONE);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.GONE);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setVisibility(View.VISIBLE);

    }

    private void hideStopButton(){

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.VISIBLE);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.VISIBLE);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setVisibility(View.GONE);

    }

    private void updateTimer () {

        final TextView timeText = (TextView) findViewById(R.id.timer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hrs = time / 3600;
                int mins = (time % 3600) / 60;
                int sec = time % 60;
                // int millisec = time;
                String timerTxt = String.format("%d:%02d:%02d", hrs, mins, sec);
                timeText.setText(timerTxt);
                if (running) {

                    time++;
                }

                handler.postDelayed(this, REFRESH_RATE);
            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.stopwatch_menu, menu);

        return (true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exercise_item:
                Intent intent = new Intent(Stopwatch.this, ExerciseRecords.class);
                startActivity(intent);
                Toast.makeText(this, "Exercise Records",Toast.LENGTH_LONG).show();
                break;

            case R.id.news_item:
                Intent intent2 = new Intent(Stopwatch.this,News.class);
                startActivity(intent2);
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();
                break;

            case R.id.video_item:
                Intent intent3 = new Intent(Stopwatch.this,Record.class);
                startActivity(intent3);
                Toast.makeText(this, "Record",Toast.LENGTH_LONG).show();
                break;
            default:
                setContentView(R.layout.activity_stopwatch);

        }



        return super.onOptionsItemSelected(item);
    }


}
