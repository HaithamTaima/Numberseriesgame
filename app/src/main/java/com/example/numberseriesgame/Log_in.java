package com.example.numberseriesgame;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.example.numberseriesgame.databinding.ActivityLogInBinding;

public class Log_in extends AppCompatActivity {

    EditText email ,password;
    CheckBox check;
    Button log_in;


    SharedPreferences sp;
    SharedPreferences.Editor editor;
    public final String FULLNAME_KEY="full_name";
    public final String PASSWORD_KEY="passwordsa";
    public final String RETURN_PASSWORD_KEY="passwordre";
    public final String USER_KEY="user_name";
    public final String EMAIL_KEY="email";
    public final String DATE_KEY="date";





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityLogInBinding binding;

        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inter_data x=new inter_data();




        Intent intent = new Intent(getBaseContext(), Regstar.class);
        ActivityResultLauncher<Intent> arl =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {

                                binding.textLogUsername.setText(result.getData().getStringExtra("username"));
                                binding.textLogPassword.setText(result.getData().getStringExtra("password"));



                            }
                        });



        binding.Regstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Regstar.class);
                arl.launch(intent);


            }



        });
        sp=PreferenceManager.getDefaultSharedPreferences(this);
        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log_in.this, Game.class);

                String user = binding.textLogUsername.getText().toString();
                intent.putExtra("user name", user);
                startActivity(intent);
                String name=sp.getString("user_name","null");
                String password=sp.getString("passwordsa","null");
                Toast.makeText(getApplicationContext(), "Hello " +name, Toast.LENGTH_SHORT).show();



            }
        });










        ImageView imageView = findViewById(R.id.image);
        Glide.with(this).asGif().load("https://c.tenor.com/BcQyqZYOp5oAAAAM/midnightcm.gif")
                .into(imageView);


    }}





                


