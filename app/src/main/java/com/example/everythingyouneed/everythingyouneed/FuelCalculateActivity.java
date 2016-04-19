package com.example.everythingyouneed.everythingyouneed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class FuelCalculateActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.everythingyouneed.everythingyouneed.MESSAGE";

    // on button click go to specified activity (dont forget about adding android:onClick=".." to activity .xml file)
    public void calculateFuelCost(View view) {

        CalcFuelCost calc = new CalcFuelCost(5);
        String[] passedElems = {"costPerL", "avgFuelCost", "kmPerDay", "kmPerDayCost", "kmPerWeek", "kmPerWeekCost", "kmPerMnyh", "kmPerMnyhCost", "kmPerYr", "kmPerYrCost", "tripDist", "tripDistCost"};


        EditText cPL = (EditText) findViewById(R.id.costPerL);
        EditText aFL = (EditText) findViewById(R.id.avgFuelCost);
        EditText kPD = (EditText) findViewById(R.id.kmPerDay);

        String costPerL = cPL.getText().toString();
        String avgFuelCost = aFL.getText().toString();
        String kmPerDay = kPD.getText().toString();

//TODO add if is not numeric also pop up error
        /*if (costPerL.matches("")) {
            Toast.makeText(this, "Please enter valid value", Toast.LENGTH_SHORT).show();
            return;
        }*/
        if(TextUtils.isEmpty(costPerL)) {
            cPL.setError("Please enter valid value");

            //return //tutaj nie dalem returna zeby pokazalo oba errory na screenie
        }
        if(TextUtils.isEmpty(avgFuelCost)) {
            aFL.setError("Please enter valid value");
            return;
        }




        String[] elemsToPass = new String[3];
        elemsToPass[0] = costPerL;
        elemsToPass[1] = avgFuelCost;
        elemsToPass[2] = kmPerDay;

        //intent.putExtra(EXTRA_MESSAGE, elemsToPass);
        //startActivity(intent);
        //EditText xxx = (EditText) findViewById(R.id.kmPerDayCost);
        //String xxx = xxx.getText().toString();
        Double kpd = Double.parseDouble(kmPerDay.trim());
        Double afc = Double.parseDouble(avgFuelCost.trim());
        Double cpl = Double.parseDouble(costPerL.trim());
        Log.w( "MEOW0", "################################");
        Log.w( "MEOW0", "################################");
        Log.w( "MEOW", kmPerDay);
        Log.w( "MEOW0", "################################");
        Log.w( "MEOW0", "################################");
        Double result = calculateFuelCost(kpd, afc, cpl);
        String res= Double.toString(result);
        EditText t = (EditText) findViewById(R.id.kmPerDayCost);
        t.setText(res+"");

    }
    public static double calculateFuelCost(double d, double avgCon, double costPerL){
        //  The fuel calculation formula:
        //	distance / 100 = res
        //	res * consLtPer100km  = res2
        //	res2 * price   = totalCost
        double res  = d/100;
        double res2 = res * avgCon;
        double totalCost = round(res2 * costPerL,2);
        return totalCost;
    }
    public static double round(double d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_calculate);
    }



}
