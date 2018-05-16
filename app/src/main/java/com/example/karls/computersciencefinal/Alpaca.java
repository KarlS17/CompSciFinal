package com.example.karls.computersciencefinal;

public class Alpaca {


    public Alpaca() {
        this.typeOfAlpaca = 0;
        this.amountOfAlpacas = 5;

    }

    public void RangerAlpaca(){
        this.typeOfAlpaca = 1;
        this.amountOfAlpacas = 1;

    }

    private int typeOfAlpaca; //0 is power ranger, 1 is regular

    public int getTypeOfAlpaca() {
        return typeOfAlpaca;
    }

    public void setTypeOfAlpaca(int typeOfAlpaca) {
        this.typeOfAlpaca = typeOfAlpaca;
    }

    public int getAmountOfAlpacas() {
        return amountOfAlpacas;
    }

    public void setAmountOfAlpacas(int amountOfAlpacas) {
        this.amountOfAlpacas = amountOfAlpacas;
    }

    public int getStartingAmount() {
        return startingAmount;
    }

    public void setStartingAmount(int startingAmount) {
        this.startingAmount = startingAmount;
    }

    private int amountOfAlpacas;
    private int startingAmount = 15;


}
