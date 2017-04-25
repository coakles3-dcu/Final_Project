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


/**
 * Activity for Stopwatch functionality
 * <p>Class contains code based on
 * http://www.shawnbe.com/index.php/tutorial/tutorial-1-a-simple-stopwatch-designing-layout/
 * &
 * https://github.com/dogriffiths/HeadFirstAndroid/blob/master/chapter04/Stopwatch/app/src/main/java/com/hfad/stopwatch/StopwatchActivity.java
 * @author  dogriffiths/HeadFirstAndroid
 * &
 * http://www.android-examples.com/android-create-stopwatch-example-tutorial-in-android-studio/
 * @author  Juned Mughal</p>
 */

public class Stopwatch extends AppCompatActivity {



    // Rate for timer display to update every second
    private final int REFRESH_RATE = 1000;

    private int time = 0;

    //Boolean to check if timer is running
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        //Code for Back arrow in menu
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);



        //Calls timer method
        updateTimer();

    }


    /**
     * Processes clicking of start button
     * @param view View associated with timer running, displays stop button
     */
    public void startClick (View view){
        running= true;
        showStopButton();

    }

    /**
     * Processes clicking of Stop button
     * @param view View associated with timer stopped, start and reset buttons displayed
     */
    public void stopClick (View view){
        running=false;
        hideStopButton();
    }


    /**
     * Processes clicking of reset button
     * @param view View associated with reset, timer stopped and returned to zero
     */
    public void resetClick (View view){

        running = false;
        time = 0;
    }


    /**
     * Method to show stop button
     * <p>Once stop button is set to Visible, the start and reset buttons are not visible</p>
     */
    private void showStopButton(){

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.GONE);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.GONE);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setVisibility(View.VISIBLE);

    }


    /**
     * Method to hide the stop button
     * <p>When the start and reset buttons are visible , the stop button is not visible</p>
     */
    private void hideStopButton(){

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.VISIBLE);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.VISIBLE);
        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setVisibility(View.GONE);

    }


    /**
     * Calculates the timer updates for each second
     */
    private void updateTimer () {

        final TextView timeText = (TextView) findViewById(R.id.timer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hrs = time / 3600;
                int mins = (time % 3600) / 60;
                int sec = time % 60;
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

    /**
     * Handle selections in Records Menu
     * <p>Method contains code adapted from
     * https://www.youtube.com/watch?v=53ssqFDR_VM
     * author Kika Nduka</p>
     * @return Returns item selected
     */
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
