package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MonthsGameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months_game);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);
        buttonOption4 = findViewById(R.id.buttonOption4);

        textView1.setText(
                "Seçenek1:\n" +
                        "Mayıs\n" +
                        "Kasım\n" +
                        "Ağustos\n" +
                        "Şubat\n" +
                        "Eylül\n" +
                        "Nisan\n" +
                        "Temmuz\n" +
                        "Haziran\n" +
                        "Mart\n" +
                        "Ocak\n" +
                        "Aralık\n" +
                        "Ekim");
        textView1.setTypeface(null, Typeface.BOLD);

        textView2.setText(
                "Seçenek2:\n" +
                        "Ağustos\n" +
                        "Kasım\n" +
                        "Ocak\n" +
                        "Temmuz\n" +
                        "Eylül\n" +
                        "Mayıs\n" +
                        "Mart\n" +
                        "Haziran\n" +
                        "Şubat\n" +
                        "Nisan\n" +
                        "Aralık\n" +
                        "Ekim");
        textView2.setTypeface(null, Typeface.BOLD);

        textView3.setText(
                "Seçenek3:\n" +
                        "Eylül\n" +
                        "Haziran\n" +
                        "Kasım\n" +
                        "Ocak\n" +
                        "Ağustos\n" +
                        "Nisan\n" +
                        "Temmuz\n" +
                        "Ekim\n" +
                        "Mart\n" +
                        "Mayıs\n" +
                        "Şubat\n" +
                        "Aralık");
        textView3.setTypeface(null, Typeface.BOLD);

        textView4.setText(
                "Seçenek4:\n" +
                        "Ocak\n" +
                        "Şubat\n" +
                        "Mart\n" +
                        "Nisan\n" +
                        "Mayıs\n" +
                        "Haziran\n" +
                        "Temmuz\n" +
                        "Ağustos\n" +
                        "Eylül\n" +
                        "Ekim\n" +
                        "Kasım\n" +
                        "Aralık");
        textView4.setTypeface(null, Typeface.BOLD);
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MonthsGameActivity.this, "Yanlış seçenek. Tekrar deneyin.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MonthsGameActivity.this, "Yanlış seçenek. Tekrar deneyin.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MonthsGameActivity.this, "Yanlış seçenek. Tekrar deneyin.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MonthsGameActivity.this, "Tebrikler! Doğru seçenek.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}