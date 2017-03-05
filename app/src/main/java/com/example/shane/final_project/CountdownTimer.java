package com.example.shane.final_project;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CountdownTimer extends AppCompatActivity {

    private long timeMilliSeconds = 1*60000;

    CountDownTimer countDownTimer;
    int time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_timer);


        final Button start = (Button) findViewById(R.id.btn_start);
        Button reset = (Button) findViewById(R.id.btn_reset);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterTime();
                startCountdownTimer();


            }
        });




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });


    }



    private void startCountdownTimer() {



        final TextView time = (TextView) findViewById(R.id.textTime);
        countDownTimer = new CountDownTimer(timeMilliSeconds, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText(formatTime(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                time.setText(formatTime(timeMilliSeconds));

            }
        }.start();
        countDownTimer.start();


    }

    private String formatTime(long millisUntilFinished) {

        long minute = (millisUntilFinished/1000*60)%60;
        long second = (millisUntilFinished/1000)%60;


        String formatTime = String.format("%02d:%02d",minute,second);


        return formatTime;

    }

    private long enterTime() {



        EditText time_entered = (EditText) findViewById(R.id.minutes);
        time = Integer.parseInt(time_entered.getText().toString().trim());
        timeMilliSeconds = time*60*1000;

        return timeMilliSeconds;


    }
}
