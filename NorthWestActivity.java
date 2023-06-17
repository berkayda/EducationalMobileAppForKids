package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NorthWestActivity extends AppCompatActivity {

    private Button buttonPrevious;
    private Button buttonNext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northwest);

        buttonPrevious = findViewById(R.id.button_previous_northwest);
        buttonNext = findViewById(R.id.button_next_northwest);

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthWestActivity.this, WestActivity.class);
                startActivity(intent);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NorthWestActivity.this,CategoryActiviy.class);
                startActivity(intent);
            }
        });
    }
}
