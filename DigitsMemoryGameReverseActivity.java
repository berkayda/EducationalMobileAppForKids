package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DigitsMemoryGameReverseActivity extends AppCompatActivity {

    private TextView textViewNumbers;
    private Button buttonNext;
    private Button buttonRemember;

    private List<Integer> numbers;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits_memory_game_reverse);

        textViewNumbers = findViewById(R.id.text_view_numbers);
        buttonNext = findViewById(R.id.button_next);
        buttonRemember = findViewById(R.id.button_remember);

        numbers = generateRandomNumbers();
        currentIndex = numbers.size() - 1;

        updateNumberText();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateNumberText();
                } else {
                    startRememberNumbersActivity();
                }
            }
        });

        buttonRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DigitsMemoryGameReverseActivity.this, RememberNumbersActivity.class);
                intent.putIntegerArrayListExtra("numbers", (ArrayList<Integer>) numbers);
                startActivity(intent);
            }
        });
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.add(randomNumber);
        }

        Collections.reverse(randomNumbers);

        return randomNumbers;
    }

    private void updateNumberText() {
        int number = numbers.get(currentIndex);
        textViewNumbers.setText(String.valueOf(number));
    }

    private void startRememberNumbersActivity() {
        Intent intent = new Intent(DigitsMemoryGameReverseActivity.this, RememberNumbersActivity.class);
        intent.putIntegerArrayListExtra("numbers", (ArrayList<Integer>) numbers);
        startActivity(intent);
    }
}