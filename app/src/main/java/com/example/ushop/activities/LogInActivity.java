package com.example.ushop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ushop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    EditText emailSignin,passwordSignin;
     private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        emailSignin = findViewById(R.id.signInEmail);
        passwordSignin = findViewById(R.id.signInPassword);
    }

    public void LogInSignup(View view) {

        //startActivity(new Intent(LogInActivity.this,MainActivity.class));

        String userEmail = emailSignin.getText().toString();
        String userPassword = passwordSignin.getText().toString();

        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this,"Enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userPassword.length() < 6) {
            Toast.makeText(this,
                    "Password is too short, enter a minimum of 6 characters!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

////        startActivity(new Intent(LogInActivity.this,MainActivity.class));

        auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(LogInActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LogInActivity.this,
                                            "LogIn successful!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LogInActivity.this,ProductCategory.class));
                                }else {
                                    Toast.makeText(LogInActivity.this,
                                            "Registration failed!"+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

    }

    public void LogInRegister(View view) {
        startActivity(new Intent(LogInActivity.this,RegistrationActivity.class));
    }
}