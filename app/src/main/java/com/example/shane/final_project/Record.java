package com.example.shane.final_project;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Activity for Video Recording Functionality
 * <p>Class contains code adapted form
 * https://www.youtube.com/watch?v=5sEeprYnHa8#t=1405.122058
 * @author Mobile Application Tutorials
 * &
 * https://www.youtube.com/watch?v=BC0BcwYFCas
 * @author Solo Traveler Hari
 * &
 * SDA Mobile Development Application Development
 * @author Colette Kirwan & Dr. Eamon Costello </p>
 */

public class Record extends AppCompatActivity {


    private static final int CAMERA_RECORD_REQUEST_CODE = 1;

    private VideoView videoView;
    private Button recButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //Code for back arrow to return to home screen

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        //setting videoView to the videoView in layout

        videoView = (VideoView) findViewById(R.id.videoView);

        //setting the recButton to the recButton in the layout

        recButton = (Button) findViewById(R.id.recButton);

        //setting the onClicklistener for the record button

        recButton.setOnClickListener(new View.OnClickListener() {
            @Override

            /**
             * Call the method to capture the video
             */
            public void onClick(View v) {

                captureVideo();
            }
        });
    }

    /**
     * Method to capture the video
     * <p>Intent to call Video Capture functionality from Mediastore
     *</p>
     */
    private void captureVideo(){

        Intent recIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        startActivityForResult(recIntent,CAMERA_RECORD_REQUEST_CODE);


    }

    @Override


    /**
     * Starts the Video view
     * <p>Starts video view once it receives the request code, result code and data from the capture video</p>
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == CAMERA_RECORD_REQUEST_CODE){
            if(resultCode == RESULT_OK){

                videoView.setVisibility(View.VISIBLE);
                videoView.start();

            }
        }

    }



    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.video_menu, menu);

        return (true);

    }

    /**
     * Handle selections in Records Menu
     * <p>Method contains code adapted from
     * https://www.youtube.com/watch?v=53ssqFDR_VM
     * @author Kika Nduka</p>
     * @return Returns item selected
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exercise_item:
                Intent intent = new Intent(Record.this, ExerciseRecords.class);
                startActivity(intent);
                Toast.makeText(this, "Exercise Records",Toast.LENGTH_LONG).show();
                break;

            case R.id.stopwatch_item:
                Intent intent1 = new Intent(Record.this,Stopwatch.class);
                startActivity(intent1);
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();
                break;

            case R.id.news_item:
                Intent intent2 = new Intent(Record.this,News.class);
                startActivity(intent2);
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();
                break;
            default:
                setContentView(R.layout.activity_record);


        }



        return super.onOptionsItemSelected(item);
    }

}
