package com.quiz.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mouttaqui.quizapp_o41.R;

public class MainActivity extends AppCompatActivity {
EditText etLogin, etPassword;
Button bLogin;
TextView tvRegister;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        etLogin= (EditText) findViewById(R.id.etLogin);
        etPassword= (EditText) findViewById(R.id.etPassword);
        bLogin= (Button) findViewById(R.id.bLogin);
        tvRegister= (TextView) findViewById(R.id.tvRegister);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginUserAccount();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }

    private void loginUserAccount() {

        String login = etLogin.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();

        if (login.isEmpty()) {
            etLogin.setError("Wprowadź adres email! ");
            etLogin.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(login).matches()) {
            etLogin.setError("Wprowadź poprawny adres email!");
            etLogin.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            etPassword.setError("Wprowadź hasło! ");
            etPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(login,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),
                            "Witamy!",
                            Toast.LENGTH_LONG)
                            .show();
                    Intent intent
                            = new Intent(MainActivity.this,
                            Quiz_topic.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Logowanie nieudane! Spróbuj ponownie!",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }





}