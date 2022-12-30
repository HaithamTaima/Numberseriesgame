package com.example.numberseriesgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.numberseriesgame.databinding.ActivityChangePasswerdBinding;

public class Change_passwerd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChangePasswerdBinding binding;
         binding=ActivityChangePasswerdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sp;
    }
}