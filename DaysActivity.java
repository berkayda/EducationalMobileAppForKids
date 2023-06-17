package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DaysActivity extends AppCompatActivity {

    private Button buttonContinue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);


        ImageView imageViewDays = findViewById(R.id.imageViewDays);
        imageViewDays.setImageResource(R.drawable.days); // R.drawable.days_image, resminizi uygun şekilde değiştirin


    }
}
