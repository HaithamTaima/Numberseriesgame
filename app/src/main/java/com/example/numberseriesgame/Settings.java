package com.example.numberseriesgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.numberseriesgame.databinding.ActivitySettingsBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Settings extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivitySettingsBinding binding;
        super.onCreate(savedInstanceState);
        binding=ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Settings.this,All_game_list.class);
                startActivity(intent);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Settings.this,Game.class);
                startActivity(intent

                );
                finish();
            }
        });

binding.btnShowLast.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Database_newGame pb=new Database_newGame();
        MyDataBase dataBase=new MyDataBase(getBaseContext());
        String title = pb.getPlayer_date();
        Toast.makeText(getBaseContext(), ""+title, Toast.LENGTH_SHORT).show();







    }
});
binding.clearGameHistory.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

binding.changePassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(Settings.this,Change_passwerd.class);
        startActivity(intent);

    }
});





    }

    public boolean isvalidateemail(final String email) {
        Pattern pattern;
        Matcher matcher;
        final String emailpatter = "[a-zA-Z0-9._-]+@[a-z]+//.+[a-z]+";
        pattern = Pattern.compile(emailpatter);
        matcher = pattern.matcher(email);
        return matcher.matches();


    }
}