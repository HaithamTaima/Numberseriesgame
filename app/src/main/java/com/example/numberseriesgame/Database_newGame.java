package com.example.numberseriesgame;

public class Database_newGame {

    private String player_name;
    private String player_date;
    private int score;


    public Database_newGame() {

    }

    public Database_newGame(int player_name, String player_date, int score) {
        //this.player_name = player_name;
        this.player_date = player_date;
        this.score = score;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_date() {
        return player_date;
    }

    public void setPlayer_date(String player_date) {
        this.player_date = player_date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getName() {
        return 0;
    }

    public int getTime_date() {
        return 0;
    }
}
