package com.quiz.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.mouttaqui.quizapp_o41.R;

public class Quiz_topic extends AppCompatActivity {

    private String selectedTopicName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_topic);

        final LinearLayout science = findViewById(R.id.ScienceLayout);
        final LinearLayout geo= findViewById(R.id.GeoLayout);
        final LinearLayout java = findViewById(R.id.LitLayout);
        final LinearLayout eu4 = findViewById(R.id.PopLayout);

        final Button startBtn = findViewById(R.id.BstartQuiz);


        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Wiedza ogólna";

                science.setBackgroundResource(R.drawable.round_back_white_stroke10);

                geo.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                eu4.setBackgroundResource(R.drawable.round_back_white10);


            }
        });

        geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Geografia";

                geo.setBackgroundResource(R.drawable.round_back_white_stroke10);

                science.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                eu4.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Java";

                java.setBackgroundResource(R.drawable.round_back_white_stroke10);

                science.setBackgroundResource(R.drawable.round_back_white10);
                geo.setBackgroundResource(R.drawable.round_back_white10);
                eu4.setBackgroundResource(R.drawable.round_back_white10);
            }
        });
        eu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "EU4";

                eu4.setBackgroundResource(R.drawable.round_back_white_stroke10);

                science.setBackgroundResource(R.drawable.round_back_white10);
                geo.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTopicName.isEmpty()){
                    Toast.makeText(Quiz_topic.this, "Proszę wybrać temat!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(Quiz_topic.this, QuizActivity.class);
                    intent.putExtra("wybranyTemat", selectedTopicName);
                    startActivity(intent);
                }
            }
        });
    }
}