package com.example.numberseriesgame;

public class Data {
    private  String name;
    private int score;
    private int time_date;

    public Data(String name, int score, int time_date) {
        this.name = name;
        this.score = score;
        this.time_date = time_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime_date() {
        return time_date;
    }

    public void setTimedate(int time_date) {
        this.time_date = time_date;
    }
}
