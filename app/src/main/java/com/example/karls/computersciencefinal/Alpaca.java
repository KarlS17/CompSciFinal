package com.example.karls.computersciencefinal;


public class Alpaca {
    private int numOfAlpacas = 15;
    private int rareAlpacas;
    private double Position =100;


    public void setPosition(double position) {
        Position = position;
    }



    public void numOfLlamasOnScreen(){

    }

    public int getNumOfAlpacas() {
        return numOfAlpacas;
    }

    public void setNumOfAlpacas(int numOfAlpacas) {
        this.numOfAlpacas += numOfAlpacas;
    }

    public int getRareAlpacas() {
        return rareAlpacas;
    }

    public void setRareAlpacas(int rareAlpacas) {
        this.rareAlpacas = rareAlpacas;
    }

    public double getPosition() {return Position;}

}
