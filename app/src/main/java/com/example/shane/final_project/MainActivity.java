package com.example.shane.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1 = (ImageView)findViewById(R.id.imageView1);
        img1.setOnClickListener(this);

        ImageView img2 = (ImageView)findViewById(R.id.imageView2);
        img2.setOnClickListener(this);

        ImageView img3 = (ImageView)findViewById(R.id.imageView3);
        img3.setOnClickListener(this);

        ImageView img4 = (ImageView)findViewById(R.id.imageView4);
        img4.setOnClickListener( this);


    }
    public void onClick(View v){

        if(v.getId()==R.id.imageView1){

            Intent intent = new Intent(this,ExerciseRecords.class);
            this.startActivity(intent);

        }else if(v.getId()==R.id.imageView2){

            Intent intent = new Intent(this,Record.class);
            this.startActivity(intent);

        }else if(v.getId()==R.id.imageView3){

            Intent intent = new Intent(this,News.class);
            this.startActivity(intent);

        }else if(v.getId()==R.id.imageView4){

            Intent intent = new Intent(this,Stopwatch.class);
            this.startActivity(intent);

        }

        return ;

    }
}
