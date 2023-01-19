package com.quiz.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.mouttaqui.quizapp_o41.R;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuiz);
        final TextView correctAnswers = findViewById(R.id.tvCorrectAnswers);
        final TextView incorrectAnswers = findViewById(R.id.tvIncorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("prawidlowo",0);
        final int getIncorrectAnswers = getIntent().getIntExtra("nieprawidlowo",0);

        correctAnswers.setText(String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText(String.valueOf(getIncorrectAnswers));

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this,Quiz_topic.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this,Quiz_topic.class));
        finish();
    }
}