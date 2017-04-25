package com.example.shane.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Activity to fetch data from web address and display in recycler view
 * <p>Class contains code based on
 * https://www.youtube.com/watch?v=19NSla4FNdQ&list=PLOvzGCa-rsH-9QjlFBVHfBNUzPGHGzj-5
 * @author Amar Yadav</p>
 */
public class News extends AppCompatActivity {

    // Declare recycler view
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        //Code for Back arrow in menu
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        // Assign declared recycler view to recyclerview in layout
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // create object of RSSRead and pass it the context and recycler view
        RSSRead readRss = new RSSRead(this, recyclerView);
        readRss.execute();


    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.news_menu, menu);

        return (true);



        /**
         * Handle selections in Menu
         * <p>Method contains code adapted from
         * https://www.youtube.com/watch?v=53ssqFDR_VM
         * author Kika Nduka</p>
         * @return Returns item selected
         */
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exercise_item:
                Intent intent = new Intent(News.this, ExerciseRecords.class);
                startActivity(intent);
                Toast.makeText(this, "Exercise Records",Toast.LENGTH_LONG).show();
                break;

            case R.id.stopwatch_item:
                Intent intent1 = new Intent(News.this,Stopwatch.class);
                startActivity(intent1);
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();
                break;


            case R.id.video_item:
                Intent intent3 = new Intent(News.this,Record.class);
                startActivity(intent3);
                Toast.makeText(this, "Record",Toast.LENGTH_LONG).show();
                break;
            default:
                setContentView(R.layout.activity_news);

        }



        return super.onOptionsItemSelected(item);
    }

}