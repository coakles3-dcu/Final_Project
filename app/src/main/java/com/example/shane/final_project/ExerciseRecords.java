package com.example.shane.final_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExerciseRecords extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editExercise, editWeight,editReps, editID;
    Button addData;
    Button viewAllRecords, updatebtn, deletebtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_records);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        myDb = new DatabaseHelper(this);

        editExercise = (EditText) findViewById(R.id.exercise_editText);
        editWeight = (EditText) findViewById(R.id.weight_editText);
        editReps = (EditText) findViewById(R.id.reps_editText);
        editID = (EditText) findViewById(R.id.id_editText);
        addData = (Button) findViewById(R.id.add_button);
        viewAllRecords = (Button) findViewById(R.id.allRecordsbutton);
        updatebtn = (Button) findViewById(R.id.update_button);
        deletebtn = (Button) findViewById(R.id.delete_buttonId);

        addRecords();
        getAllResults();
        upDateRecords();
        deleteRecords();



    }


    public void deleteRecords(){

        deletebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRecords = myDb.deleteRecord(editID.getText().toString());

                        if(deletedRecords > 0)
                            Toast.makeText(ExerciseRecords.this, "Record deleted", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(ExerciseRecords.this, "Record has not been deleted", Toast.LENGTH_LONG).show();

                    }
                }

        );
    }



    public void addRecords(){

        addData.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isRecorded =  myDb.addRecords(editExercise.getText().toString(),
                                editWeight.getText().toString(),
                                editReps.getText().toString());

                        if(isRecorded == true)
                            Toast.makeText(ExerciseRecords.this, "Record has been added", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(ExerciseRecords.this, "Record has not been added", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


    public void upDateRecords(){

        updatebtn.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDb.updateResults(editID.getText().toString(),
                                editExercise.getText().toString(),
                                editWeight.getText().toString(),
                                editReps.getText().toString());

                        if(isUpdated == true)

                            Toast.makeText(ExerciseRecords.this, "Record has been Updated", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(ExerciseRecords.this, "Record has not been Updated", Toast.LENGTH_LONG).show();
                    }
                }

        );


    }


    public void getAllResults(){


        viewAllRecords.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor records = myDb.getAllRecords();

                        if(records.getCount() == 0){

                            displayMessage(" Error ", "No Records Found ");

                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(records.moveToNext()){

                            buffer.append("ID : "+ records.getString(0)+ "\n");
                            buffer.append("EXERCISE : "+ records.getString(1)+ "\n");
                            buffer.append("WEIGHT : "+ records.getString(2)+ "\n");
                            buffer.append("REPS : "+ records.getString(3)+ "\n\n");



                        }


                        displayMessage("Records", buffer.toString());

                    }
                }

        );

    }

    public void displayMessage(String Title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();

    }



    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.exercise_menu, menu);

        return (true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){

            case R.id.stopwatch_item:
                Intent intent1 = new Intent(ExerciseRecords.this,Stopwatch.class);
                startActivity(intent1);
                Toast.makeText(this, "Stopwatch",Toast.LENGTH_LONG).show();
                break;

            case R.id.news_item:
                Intent intent2 = new Intent(ExerciseRecords.this,News.class);
                startActivity(intent2);
                Toast.makeText(this, "News",Toast.LENGTH_LONG).show();
                break;


            case R.id.video_item:
                Intent intent3 = new Intent(ExerciseRecords.this,Record.class);
                startActivity(intent3);
                Toast.makeText(this, "Record",Toast.LENGTH_LONG).show();
                break;
            default:
                setContentView(R.layout.activity_exercise_records);

        }



        return super.onOptionsItemSelected(item);
    }
}
