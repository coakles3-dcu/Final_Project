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

public class Record extends AppCompatActivity {


    private static final int CAMERA_RECORD_REQUEST_CODE = 1;

    private VideoView videoView;
    private Button recButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        videoView = (VideoView) findViewById(R.id.videoView);
        recButton = (Button) findViewById(R.id.recButton);


        recButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                captureVideo();
            }
        });
    }

    private void captureVideo(){

        Intent recIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        startActivityForResult(recIntent,CAMERA_RECORD_REQUEST_CODE);


    }

    @Override

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
