package com.example.everythingyouneed.everythingyouneed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {


    //
    public final static String EXTRA_MESSAGE = "com.example.everythingyouneed.everythingyouneed.MESSAGE";

    // on button click go to specified activity (dont forget about adding android:onClick=".." to activity .xml file)
    public void initiateFuelCalculator(View view) {

        //Specify which activity to run(.java) [intencje/zamiar]
        Intent intent = new Intent(this, FuelCalculateActivity.class);

        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
