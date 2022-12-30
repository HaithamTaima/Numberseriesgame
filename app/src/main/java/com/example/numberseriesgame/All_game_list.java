package com.example.numberseriesgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.numberseriesgame.databinding.ActivityAllGameListBinding;

import java.util.ArrayList;

public class All_game_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityAllGameListBinding binding;
        super.onCreate(savedInstanceState);
        binding =ActivityAllGameListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyDataBase dataBase =new MyDataBase(getBaseContext());
        ArrayList<Database_newGame> database_newGames =dataBase.newGames();
        Gameadubture gameadubture =new Gameadubture(database_newGames,this);
        binding.rc.setAdapter(gameadubture);
        binding.rc.setHasFixedSize(true);
        binding.rc.setLayoutManager(new LinearLayoutManager(this));


//
//        ArrayList<Data> games =new ArrayList<>();
//        games.add(new Data("yousuf",50,3/5/2022));
//        games.add(new Data("ahmed",40,23/2/2022));
//        games.add(new Data("ahmed",40,23/2/2022));
//        games.add(new Data("yousuf",30,12/8/2022));


    //Gameadubture gameadubture=new Gameadubture(games,this);







    }

}