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


/**
 * Main Activity for Final_Project App
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Buttons to launch different Activities
     */

    Button exerbtn, newsbtn, vidbtn, timerbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Link button exerbtn to records_button in main layout & Enable onClick Functionality
         */
        exerbtn = (Button) findViewById(R.id.records_button);
        exerbtn.setOnClickListener(this);


        /**
         * Link button newsbtn  to news_button in main layout & Enable onClick Functionality
         */
        newsbtn = (Button) findViewById(R.id.news_button);
        newsbtn.setOnClickListener(this);


        /**
         * Link button vidbtn  to recordvid_button in main layout & Enable onClick Functionality
         */
        vidbtn = (Button) findViewById(R.id.recordvid_button);
        vidbtn.setOnClickListener(this);


        /**
         * Link button timerbtn  to stopwatch_button in main layout & Enable onClick Functionality
         */
        timerbtn = (Button) findViewById(R.id.stopwatch_button);
        timerbtn.setOnClickListener(this);
    }


    /**
     * Handle onClick of activity button chosen by user
     * @param v View associated with choice of user
     */
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
    /**
     * Inflates the main options menu
     */
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return (true);
    }


    @Override

    /**
     * Handle selections in Menu
     * <p>Method contains code adapted from
     * https://www.youtube.com/watch?v=53ssqFDR_VM
     * author Kika Nduka</p>
     * @return Returns item selected
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            /**
             * Launches ExerciseRecords class with an intent once exercise item has been selected
             */
            case R.id.exercise_item:
                Intent intent = new Intent(MainActivity.this, ExerciseRecords.class);
                startActivity(intent);

                /**
                 * Displays message telling user they are on the exercise page
                 */
                Toast.makeText(this, "Exercise Records",Toast.LENGTH_LONG).show();
                break;


            /**
             * Launches Stopwatch class with an intent once stopwatch item has been selected
             */
            case R.id.stopwatch_item:
                Intent intent1 = new Intent(MainActivity.this,Stopwatch.class);
                startActivity(intent1);

                /**
                 * Displays message telling user they are on on the stopwatch page
                 */
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();
                break;


            /**
             * Launches News class with an intent once news item has been selected
             */
            case R.id.news_item:
                Intent intent2 = new Intent(MainActivity.this,News.class);
                startActivity(intent2);

                /**
                 * Displays message telling user they are on on the stopwatch page
                 */
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();
                break;

            /**
             *  Launches Record class with an intent once video item has been selected
             */
            case R.id.video_item:
                Intent intent3 = new Intent(MainActivity.this,Record.class);
                startActivity(intent3);

                /**
                 * Displays message telling user they are on on the record page
                 */
                Toast.makeText(this, "Record",Toast.LENGTH_LONG).show();
                break;

            default:
                setContentView(R.layout.activity_main);

        }



        return super.onOptionsItemSelected(item);
    }
}
