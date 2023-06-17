package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RememberNumbersActivity extends AppCompatActivity {

    private TextView textViewNumbers;
    private EditText editTextNumbers;
    private Button buttonCheck;

    private List<Integer> numbers;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_numbers);

        textViewNumbers = findViewById(R.id.text_view_numbers);
        editTextNumbers = findViewById(R.id.edit_text_numbers);
        buttonCheck = findViewById(R.id.button_check);

        numbers = getIntent().getIntegerArrayListExtra("numbers");
        currentIndex = 0;

        updateNumberText();

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumbers();
            }
        });
    }

    private void updateNumberText() {
        int number = numbers.get(currentIndex);
        textViewNumbers.setText(String.valueOf(number));
    }

    private void checkNumbers() {
        String input = editTextNumbers.getText().toString().trim().replaceAll("-", "");
        String expectedNumbers = TextUtils.join("", numbers);

        if (input.equals(expectedNumbers)) {
            Toast.makeText(this, "Congratulations! Numbers are correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Oops! Numbers are incorrect!", Toast.LENGTH_SHORT).show();
        }
    }


}
