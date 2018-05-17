package com.example.karls.computersciencefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Alpaca theAlpacas = new Alpaca();

    private int day = 0;
    private int food = 15;

    //Screen size

    private double screenWidth;
    private double screenHieght;

    TextView numOfAlpacas;
    TextView foodCount;
    TextView dayCount;  //Textview for Daycount


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button eatButton = findViewById(R.id.eatButton);    //Creates eat button
        Button newAlpaca = findViewById(R.id.newAlpaca);      //Creates New Alpaca button
        Button sleepButton = findViewById(R.id.sleep);      //Creates Sleep button

        this.dayCount = findViewById(R.id.dayCount);
        this.numOfAlpacas = findViewById(R.id.numOfAlpacas);
        this.foodCount = findViewById(R.id.food);

        //Sleep Button Method
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayCount.setText("Day " + day++ );
            }
        });

        //Eat Button
        eatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int foodNeeded = theAlpacas.getNumOfAlpacas()/3; //5 if num of alpacas is 15
                food = food-foodNeeded;
                foodCount.setText(food + " Pieces of Food Remaining");


            }
        });




    }






    }

