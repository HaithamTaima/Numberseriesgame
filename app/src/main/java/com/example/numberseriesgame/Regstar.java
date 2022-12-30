package com.example.numberseriesgame;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.numberseriesgame.databinding.ActivityRegstarBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regstar extends AppCompatActivity{

    public static final int EX_RQ=1;
    private static final int WRITE_EX_EQ =1 ;
    private static final int WRITE_EX_RQ = 1;

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
        ActivityRegstarBinding binding;
        super.onCreate(savedInstanceState);
        binding=ActivityRegstarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActivityResultLauncher<String>arl=
                registerForActivityResult(new ActivityResultContracts.GetContent(),
                        new ActivityResultCallback<Uri>() {
                            @Override
                            public void onActivityResult(Uri result) {
                                binding.imgPerson.setImageURI(result);

                            }
                        })
                ;


        if (ContextCompat.checkSelfPermission
                (this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED) {
            String[]permission ={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this,permission,WRITE_EX_EQ);
        }


        sp= PreferenceManager.getDefaultSharedPreferences(this);
        editor=sp.edit();
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = binding.nameRegstar.getText().toString();
                String password = binding.passwordReturn.getText().toString();


                Intent intent = new Intent();
                intent.putExtra("username", username);
                intent.putExtra("password", password);


                setResult(RESULT_OK, intent);
                finish();

                String full_name = binding.fullnameRegstar.getText().toString();
                String email = binding.txtemailRegstar.getText().toString();

                String user_name = binding.nameRegstar.getText().toString();
                String passwordre = binding.passwordReturn.getText().toString();
                String passwordsa = binding.txtRepasswordRegstar.getText().toString();

                editor.putString(FULLNAME_KEY, full_name);
                editor.putString(EMAIL_KEY, email);
                editor.putString(USER_KEY, user_name);
                editor.putString(PASSWORD_KEY, passwordsa);
                editor.putString(RETURN_PASSWORD_KEY, passwordre);

                editor.apply();

                if (!isvalidateemail(binding.txtemailRegstar.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "invaild e,ail", Toast.LENGTH_SHORT).show();
                    binding.txtemailRegstar.setError("invalid email");
                    binding.txtemailRegstar.requestFocus();

                } else
                    Toast.makeText(getApplicationContext(), "sucssesful", Toast.LENGTH_SHORT).show();



            }
        });
        String date =binding.txtDate.getText().toString();
        Intent intent =new Intent();
        intent.putExtra("date",date);

        binding.nameRegstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String date =binding.txtDate.getText().toString();
                intent.putExtra("date",date);
                setResult(RESULT_OK);
            }
        });


        binding.imgPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arl.launch("image/*");

            }
        });
        binding.txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                                binding.txtDate.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                            }

                        },
                        now.get(Calendar.YEAR), // Initial year selection
                        now.get(Calendar.MONTH), // Initial month selection
                        now.get(Calendar.DAY_OF_MONTH) // Inital day selection

                );

                dpd.show(getSupportFragmentManager(), "Datepickerdialog");

            }
        });



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode) {
            case WRITE_EX_RQ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }
                return;
        }



    }


    public boolean isvalidateemail(final String email){
        Pattern pattern;
        Matcher matcher;
        final String emailpatter ="[a-zA-Z0-9._-]+@[a-z]+//.+[a-z]+";
        pattern =Pattern.compile(emailpatter);
        matcher=pattern.matcher(email);
        return matcher.matches();





    }

}




