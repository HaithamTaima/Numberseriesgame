package com.example.numberseriesgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.bumptech.glide.util.Util;
import com.example.numberseriesgame.databinding.ActivityGameBinding;

public class Game extends AppCompatActivity {


    ActivityGameBinding binding;
    int hidden;
    int score =0;
    //MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());


        binding.enterNum.getText().toString();
        // binding.Age.getText().toString();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user name");


        binding.txtNameGame.setText(user);
        binding.tvScore.setText(String.valueOf(score));


        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("Welcom");

        hidden = storage_number();



       String answer = binding.enterNum.getText().toString();



       binding.btnCheck.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               if (answer.equals(String.valueOf(hidden))) {



                //   CuteToast.ct(this, "This is a Sad Toast", CuteToast.LENGTH_SHORT, CuteToast.SAD, true).show();

                   Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT).show();
                    score+=5;
//                   Toast t = new Toast(getBaseContext());
//                   t.setView(toast);
//                   t.setDuration(Toast.LENGTH_LONG);
//                   t.show();
               } else {
//                   MediaPlayer.create(getBaseContext(),R.raw.splach_music);
//
//                   mediaPlayer.start();





                   Toast.makeText(getBaseContext(), "false", Toast.LENGTH_SHORT).show();


//                   Toast t = new Toast(getBaseContext());
//                   t.setView(toast);
//                   t.setDuration(Toast.LENGTH_LONG);
//                   t.show();

                   storage_number();




               }
           }
       });




       binding.btnNewGame.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               storage_number();

//               MyDataBase dataBase =new MyDataBase(getBaseContext());
//              boolean news= dataBase.insertnewGame(dataBase);



               Database_newGame play =new Database_newGame();
              MyDataBase db=new MyDataBase(getBaseContext());
               boolean save =db.insertGame(play);
               if (save)
               {
                   Toast.makeText(getBaseContext(), "done ", Toast.LENGTH_SHORT).show();

               }


           }
       });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menun, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(Game.this, Settings.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.logout:
                finish();
                return true;


        }
        return false;
    }


    public int storage_number() {
        Util util = new Util(this);
        Question question = util.generateQuestion();
        binding.txt1.setText(question.getDate()[0][0]);
        binding.txt2.setText(question.getDate()[0][1]);
        binding.txt3.setText(question.getDate()[0][2]);
        binding.txt4.setText(question.getDate()[1][0]);
        binding.txt5.setText(question.getDate()[1][1]);
        binding.txt6.setText(question.getDate()[1][2]);
        binding.txt7.setText(question.getDate()[2][0]);
        binding.txt8.setText(question.getDate()[2][1]);
        binding.txt9.setText(question.getDate()[2][2]);
        return question.getHidden_number();

    }}
