package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SouthEastActivity extends AppCompatActivity {

    private Button buttonPrevious;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southeast);

        buttonPrevious = findViewById(R.id.button_previous_southeast);
        buttonNext = findViewById(R.id.button_next_southeast);

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthEastActivity.this, EastActivity.class);
                startActivity(intent);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SouthEastActivity.this, SouthActivity.class);
                startActivity(intent);
            }
        });
    }
}
