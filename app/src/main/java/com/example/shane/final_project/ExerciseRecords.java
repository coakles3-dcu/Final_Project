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

/**
 * Activity to carry out actions on our database
 * <p>Class contains code based on
 * http://www.codebind.com/android-tutorials-and-examples/android-sqlite-tutorial-example/
 * @author Mithilesh Singh
 * &
 * https://www.tutorialspoint.com/android/android_sqlite_database.htm</p>
 */

public class ExerciseRecords extends AppCompatActivity {

    //Instance of DatabaseHelper called from DatabaseHelper class
    DatabaseHelper myDb;

    //Edittext where values are to be stored, removed or updated in the database are entered
    EditText editExercise, editWeight,editReps, editID;
    Button addData;
    Button viewAllRecords, updatebtn, deletebtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_records);

        //Code for Back arrow in menu
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

       // create a new instance of database helper
        myDb = new DatabaseHelper(this);


        //Cast all buttons and textviews
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


    /**
     * Deletes records from the database
     */
    public void deleteRecords(){

        deletebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //deletes records from the database according to the integer entered by user
                        Integer deletedRecords = myDb.deleteRecord(editID.getText().toString());

                        //displays toast message
                        if(deletedRecords > 0)
                            Toast.makeText(ExerciseRecords.this, "Record deleted", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(ExerciseRecords.this, "Record has not been deleted", Toast.LENGTH_LONG).show();

                    }
                }

        );
    }


    /**
     * Adds data entered by user to the database
     */
    public void addRecords(){

        addData.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // takes all values entered, converts them to string values and adds them to the database
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


    /**
     * updates a record by the ID chosen by the user
     */
    public void upDateRecords(){

        updatebtn.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Selects the record by the Id entered and updates all fields
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


    /**
     * Gets all the records stored in the database
     */
    public void getAllResults(){


        viewAllRecords.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //cursor to move throught the data in the database
                        Cursor records = myDb.getAllRecords();

                        if(records.getCount() == 0){

                            displayMessage(" Error ", "No Records Found ");

                            return;
                        }

                        //Stringbuffer to hold all values as they are passed to it
                        StringBuffer buffer = new StringBuffer();
                        // gives the first column and moves on to next bit of data until it reaches the end
                        while(records.moveToNext()){

                            //values are added to buffer
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


    /**
     *Displays all records
     * @param Title outlined as Records in getAllResults()
     * @param Message buffer that all the data has been added to
     * <p>Receives data from getAllResults</p>
     */
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



        /**
         * Handle selections in Records Menu
         * <p>Method contains code adapted from
         * https://www.youtube.com/watch?v=53ssqFDR_VM
         * @author Kika Nduka</p>
         * @return Returns item selected
         */

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
