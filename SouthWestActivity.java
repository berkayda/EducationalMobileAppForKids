package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SouthWestActivity extends AppCompatActivity {

    private Button buttonPrevious;
    private Button buttonNext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southwest);

        buttonPrevious = findViewById(R.id.button_previous_southwest);
        buttonNext = findViewById(R.id.button_next_southwest);

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthWestActivity.this, SouthActivity.class);
                startActivity(intent);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthWestActivity.this, WestActivity.class);
                startActivity(intent);
            }
        });
    }
}
