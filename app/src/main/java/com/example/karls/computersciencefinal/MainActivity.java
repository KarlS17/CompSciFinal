package com.example.karls.computersciencefinal;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


//PREVENT FOOD GOING INTO NEGATIVES BEFORE IT UPDATES

public class MainActivity extends AppCompatActivity {


    Random rand = new Random();
    public void randomNum(){
        int val = rand.nextInt(10);
        randomVal = val;
        int specialnum = rand.nextInt(100);
        rareVal = specialnum;
    }

    Alpaca theAlpacas = new Alpaca();   //Creates Alpaca selection

    private int day = 0;
    private int food = 15;
    private int randomVal;
    private int rareVal;

/////////////////////////////Movement///////////////////////////

    private ImageView regularalpaca1;
    private ImageView regularalpaca2;
    private ImageView regularalpaca3;
    private ImageView regularAlpaca4;
    private ImageView rareAlpaca;


    //Screen size

    private double screenWidth;
    private double screenHieght;

    //Position

    private double regAlpaca1X;
    private double regAlpacaY;

    //Initalize Class

    private Handler handler = new Handler();
    private Timer timer = new Timer();


    /////////////////////////////////////////////////////////

    TextView numOfAlpacas;  //Textview for number of Alpacas
    TextView foodCount; //Textview for food counter
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

                if (theAlpacas.getNumOfAlpacas()<=0){
                    numOfAlpacas.setText("You are out of Alpacs");
                }

                else if (food<=0) {
                    foodCount.setText("You are out of food");
                }
                else {
                    int foodNeeded = theAlpacas.getNumOfAlpacas() / 3; //5 if num of alpacas is 15
                    food = food - foodNeeded;
                    foodCount.setText(food + " Pieces of Food Remaining");

                }

            }
        });

        newAlpaca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                randomNum();

                if (food<5){
                    numOfAlpacas.setText("Not enough food");
                }
                else if (randomVal > 7) {
                    food = food -3;
                    theAlpacas.setNumOfAlpacas(3);
                    numOfAlpacas.setText(theAlpacas.getNumOfAlpacas() + " Alpacas");


                } else if (randomVal>4 & randomVal<7) {
                    food = food -3;
                    theAlpacas.setNumOfAlpacas(1);
                    numOfAlpacas.setText(theAlpacas.getNumOfAlpacas() + " Alpacas");
                }

                else{
                    numOfAlpacas.setText(theAlpacas.getNumOfAlpacas() + " Alpacas");

                }

                if (rareVal==99){
                    //Rare Llama, need to set up eventually
                    theAlpacas.setNumOfAlpacas(+1);
                    food = food -3;
                }
            }});

        ///////////////////Movement//////////////////
        regularalpaca1 = (ImageView) findViewById(R.id.regularalpaca1);

        //Gets screen size

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHieght = size.y;


        //Timer Stuff

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });

            }
        },0,20);
        screenHieght = screenHieght/1.5; //Might reduce travel









    }
    public void changePos(){

        //Makes the penguin move up
        //Also moves it side to side from each reset process
        regAlpacaY -=3;//Controls speed of penguin, originally at 10
        // x speed will be faster or slower based off of the number of pingus
        if(regularalpaca1.getY() + regularalpaca1.getHeight() <0){
            //regAlpaca1X = 10; //Keeps it in position x1
            regAlpacaY = screenHieght + 20; //regAlpacaY = screenHieght + 100; //Used to be Y alpaca
        }

        regularalpaca1.setX((float)regAlpaca1X);
        regularalpaca1.setY((float)regAlpacaY);




    }






    }

