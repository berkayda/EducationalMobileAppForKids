package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MultiplexingGameActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button buttonChoice1, buttonChoice2, buttonChoice3, buttonChoice4;
    private Button buttonBack;

    private int answer;
    private int score = 0;
    private int questionCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplexing_game);

        textViewQuestion = findViewById(R.id.text_view_question);
        buttonChoice1 = findViewById(R.id.button_choice1);
        buttonChoice2 = findViewById(R.id.button_choice2);
        buttonChoice3 = findViewById(R.id.button_choice3);
        buttonChoice4 = findViewById(R.id.button_choice4);
        buttonBack = findViewById(R.id.button_back);

        generateQuestion();

        buttonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonChoice1.getText().toString());
            }
        });

        buttonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonChoice2.getText().toString());
            }
        });

        buttonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonChoice3.getText().toString());
            }
        });

        buttonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(buttonChoice4.getText().toString());
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplexingGameActivity.this, CategoryActiviy.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void generateQuestion() {
        Random random = new Random();
        int number1 = random.nextInt(12) + 1;
        int number2 = random.nextInt(12) + 1;
        answer = number1 * number2;

        textViewQuestion.setText(number1 + " x " + number2 + " = ?");

        int correctButton = random.nextInt(4) + 1;
        setButtonText(correctButton, String.valueOf(answer));

        for (int i = 1; i <= 4; i++) {
            if (i != correctButton) {
                int wrongAnswer = generateWrongAnswer();
                setButtonText(i, String.valueOf(wrongAnswer));
            }
        }
    }

    private int generateWrongAnswer() {
        Random random = new Random();
        int wrongAnswer;

        do {
            wrongAnswer = random.nextInt(144) + 1;
        } while (wrongAnswer == answer);

        return wrongAnswer;
    }

    private void setButtonText(int buttonNumber, String text) {
        switch (buttonNumber) {
            case 1:
                buttonChoice1.setText(text);
                break;
            case 2:
                buttonChoice2.setText(text);
                break;
            case 3:
                buttonChoice3.setText(text);
                break;
            case 4:
                buttonChoice4.setText(text);
                break;
        }
    }

    private void checkAnswer(String selectedAnswer) {
        int selectedValue = Integer.parseInt(selectedAnswer);

        if (selectedValue == answer) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        questionCount++;

        if (questionCount < 10) {
            generateQuestion();
        } else {
            finishGame();
        }
    }

    private void finishGame() {
        Toast.makeText(this, "Game Over! Your Score: " + score, Toast.LENGTH_SHORT).show();
        finish();
    }
}