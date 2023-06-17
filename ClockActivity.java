package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class ClockActivity extends AppCompatActivity {

    private ImageView imageViewClock;
    private RadioGroup radioGroupChoices;
    private RadioButton radioButtonChoice1, radioButtonChoice2, radioButtonChoice3, radioButtonChoice4;
    private Button buttonCheck;
    private int currentClockIndex;

    private int[] clockImages = {R.drawable.clock1, R.drawable.clock2, R.drawable.ic_launcher_background, R.drawable.clock4, R.drawable.clock5};
    private String[] clockTimes = {"01:00", "02:00", "03:00", "04:00", "05:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        imageViewClock = findViewById(R.id.imageViewClock);
        radioGroupChoices = findViewById(R.id.radioGroupChoices);
        radioButtonChoice1 = findViewById(R.id.radioButtonChoice1);
        radioButtonChoice2 = findViewById(R.id.radioButtonChoice2);
        radioButtonChoice3 = findViewById(R.id.radioButtonChoice3);
        radioButtonChoice4 = findViewById(R.id.radioButtonChoice4);
        buttonCheck = findViewById(R.id.buttonCheck);

        generateNewClock();

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupChoices.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(ClockActivity.this, "Lütfen bir seçenek seçin", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedTime = selectedRadioButton.getText().toString();

                if (clockTimes[currentClockIndex].equals(selectedTime)) {
                    Toast.makeText(ClockActivity.this, "Doğru!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ClockActivity.this, "Yanlış! Doğru cevap: " + clockTimes[currentClockIndex], Toast.LENGTH_SHORT).show();
                }

                generateNewClock();
            }
        });
    }

    private void generateNewClock() {
        Random random = new Random();
        currentClockIndex = random.nextInt(clockImages.length);
        imageViewClock.setImageResource(clockImages[currentClockIndex]);

        // Şıkları karıştır
        String correctTime = clockTimes[currentClockIndex];
        String[] choices = generateRandomChoices(correctTime);
        radioButtonChoice1.setText(choices[0]);
        radioButtonChoice2.setText(choices[1]);
        radioButtonChoice3.setText(choices[2]);
        radioButtonChoice4.setText(choices[3]);

        radioGroupChoices.clearCheck();
    }

    private String[] generateRandomChoices(String correctTime) {
        String[] choices = new String[4];
        Random random = new Random();

        // correctTime'ı saat ve dakika olarak ayır
        String correctHour = correctTime.split(":")[0];
        String correctMinute = correctTime.split(":")[1];

        // İlk şık doğru saat olacak
        choices[0] = correctTime;

        for (int i = 1; i < 4; i++) {
            int randomHour;
            int randomMinute;
            String randomTime;

            // Random saat ve dakika oluşturulacak. Bu saat ve dakika, doğru cevap olmamalı
            do {
                randomHour = random.nextInt(12) + 1; // 1 ile 12 arasında saat üretir
                randomMinute = random.nextInt(60); // 0 ile 59 arasında dakika üretir

                // Üretilen saat ve dakika eğer tek haneliyse başına '0' ekler
                String randomHourStr = randomHour < 10 ? "0" + randomHour : String.valueOf(randomHour);
                String randomMinuteStr = randomMinute < 10 ? "0" + randomMinute : String.valueOf(randomMinute);

                randomTime = randomHourStr + ":" + randomMinuteStr;

            } while (randomTime.equals(correctTime));

            choices[i] = randomTime;
        }

        // Şıkları karıştır
        shuffleArray(choices);

        return choices;
    }

    private void shuffleArray(String[] arr) {
        int index;
        String temp;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
