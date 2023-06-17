package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class MonthsActivity extends AppCompatActivity {

    private ImageView imageViewMonths;
    private TextView textViewTitle;
    private Button buttonContinue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);

        imageViewMonths = findViewById(R.id.imageViewMonths);
        textViewTitle = findViewById(R.id.textViewTitle);
        buttonContinue = findViewById(R.id.buttonContinue);

        textViewTitle.setText("Aylar");

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonthsActivity.this, MonthsGameActivity.class);
                startActivity(intent);
            }
        });

        // Yüklediğiniz resmi imageViewMonths'e atayabilirsiniz
        // Örneğin:
        // imageViewMonths.setImageResource(R.drawable.months_image);
    }
}
