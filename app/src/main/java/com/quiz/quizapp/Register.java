package com.quiz.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.mouttaqui.quizapp_o41.R;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText etName,etLogin,etPassword,etConfirm;
    Button bSign;
    TextView tvSignIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        etName = (EditText) findViewById(R.id.etName);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirm = (EditText) findViewById(R.id.etConfirm);
        bSign = (Button) findViewById(R.id.bSign);
        tvSignIn = (TextView) findViewById(R.id.tvSignIn);

        bSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });

    }
        private void registerNewUser() {

            String name = etName.getText().toString().trim();
            String login = etLogin.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();
            String confirm = etConfirm.getText().toString().trim();

            if (name.isEmpty()) {
                etName.setError("Podaj nazwę! ");
                etName.requestFocus();
                return;
            }
            if (login.isEmpty()) {
                etLogin.setError("Podaj email! ");
                etLogin.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(login).matches()) {
                etLogin.setError("Podaj prawidłowy email!");
                etLogin.requestFocus();
                return;
            }
            if (pass.isEmpty()) {
                etPassword.setError("Podaj hasło! ");
                etPassword.requestFocus();
                return;
            }
            if (pass.length() < 6) {
                etPassword.setError("Hasło powinno mieć minimum 6 znaków!");
                etPassword.requestFocus();
                return;
            }

            if (confirm.isEmpty()) {
                etConfirm.setError("Potwierdź hasło! ");
                etConfirm.requestFocus();
                return;
            }

            mAuth.createUserWithEmailAndPassword(login, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Zarejestrowano!",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent
                                        = new Intent(Register.this,
                                        MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "Rejestracja nie powiodła się!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
}









