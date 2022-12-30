package com.example.numberseriesgame;

public class  Question {
    private String[][] date;
    private int hidden_number;


    public String[][] getDate() {
        return date;
    }

    public void setDate(String[][] date) {
        this.date = date;
    }

    public int getHidden_number() {
        return hidden_number;
    }

    public void setHidden_number(int hidden_number) {
        this.hidden_number = hidden_number;
    }

    public Question(String[][] date, int hidden_number) {
        this.date = date;
        this.hidden_number = hidden_number;
    }

}