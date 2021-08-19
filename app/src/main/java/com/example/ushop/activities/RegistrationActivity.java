package com.example.ushop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ushop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    EditText name,email, password;
     private FirebaseAuth auth;

     SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();

//        hide toorbar
        getSupportActionBar().hide();

//        if(auth.getCurrentUser() != null){
//            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
//            finish();
//        }
        name = findViewById(R.id.name);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
        sharedPreferences = getSharedPreferences("OnBoardingScreen",MODE_PRIVATE);
        boolean isFirstTime = sharedPreferences.getBoolean("firstTime",true);

//        if(isFirstTime){
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putBoolean("firstTime",false);
//            editor.commit();
//
//            Intent intent = new Intent(RegistrationActivity.this,LogInActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }

    public void signup(View view) {

        //startActivity(new Intent(RegistrationActivity.this,LogInActivity.class));

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();


      if(TextUtils.isEmpty(userName)){

          Toast.makeText(this,"Enter name!", Toast.LENGTH_SHORT).show();
          return;
      }
        if(TextUtils.isEmpty(userEmail)){

            Toast.makeText(this,"Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPassword.length() < 6) {
            Toast.makeText(this,
                    "Password is too short, enter a minimum of 6 characters!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // startActivity(new Intent(RegistrationActivity.this,MainActivity.class));


        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(RegistrationActivity.this,
                        new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this,
                                    "Registration successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this,LogInActivity.class));
                        }else {
                            Toast.makeText(RegistrationActivity.this,
                                    "Registration failed!"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void signin(View view) {
        startActivity(new Intent(RegistrationActivity.this, LogInActivity.class));
    }
}