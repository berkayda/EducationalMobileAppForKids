package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SeasonActivity extends AppCompatActivity {

    private ImageView imageViewSeason;
    private TextView textViewSeasonName;
    private TextView textViewSeasonInfo;
    private Button buttonPrevious, buttonNext;
    private int currentSeasonIndex = 0;
    private int[] seasonImages = {R.drawable.spring, R.drawable.summer, R.drawable.autumn, R.drawable.winter};
    private String[] seasonNames = {"Spring", "Summer", "Autumn", "Winter"};
    private String[] seasonInfo = {"Spring is a season of rebirth and renewal. The days become longer and the weather starts to warm up. Flowers bloom and animals awaken from their winter sleep.",
            "Summer is the warmest season of the year. It is a time for outdoor activities, vacations, and relaxation. The days are longer and the weather is hot.",
            "Autumn, also known as fall, is a season of change. The leaves on the trees change color and fall to the ground. The weather becomes cooler and harvest season begins.",
            "Winter is the coldest season of the year. It is a time of snow, ice, and cold temperatures. People enjoy activities like skiing, ice skating, and building snowmen."};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);

        imageViewSeason = findViewById(R.id.imageViewSeason);
        textViewSeasonName = findViewById(R.id.textViewSeasonName);
        textViewSeasonInfo = findViewById(R.id.textViewSeasonInfo);
        buttonPrevious = findViewById(R.id.buttonPrevious);
        buttonNext = findViewById(R.id.buttonNext);

        showCurrentSeason();

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSeason();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSeason();
            }
        });
    }

    private void showCurrentSeason() {
        imageViewSeason.setImageResource(seasonImages[currentSeasonIndex]);
        textViewSeasonName.setText(seasonNames[currentSeasonIndex]);
        textViewSeasonInfo.setText(seasonInfo[currentSeasonIndex]);
    }

    private void previousSeason() {
        currentSeasonIndex--;
        if (currentSeasonIndex < 0) {
            currentSeasonIndex = seasonImages.length - 1;
        }
        showCurrentSeason();
    }

    private void nextSeason() {
        currentSeasonIndex++;
        if (currentSeasonIndex >= seasonImages.length) {
            currentSeasonIndex = 0;
        }
        showCurrentSeason();
    }
}
