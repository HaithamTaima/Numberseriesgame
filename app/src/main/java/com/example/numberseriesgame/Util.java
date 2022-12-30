package com.example.numberseriesgame;

public class Util {
    private final Game game;

    public Util(Game game) {
        this.game = game;
    }

    public Question generateQuestion() {

        String[][] x = new String[3][3];
        int Start_number = (int) (Math.random() * 10) + 1;
        int incStart_number = (int) (Math.random() * 5) + 1;
        int Stred_Number;
        int number = -1;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                Stred_Number = Start_number + incStart_number;
                if (i == 1 && j == 1) {
                    x[i][j] = "??";
                    number = Stred_Number;


                } else {
                    x[i][j] = Start_number + "";
                }


                incStart_number += 2;
                Start_number = Stred_Number;
            }

        }
        return new Question(x, number);

    }

}
