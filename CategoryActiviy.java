package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;

public class CategoryActiviy extends AppCompatActivity {

    private ListView listViewPlaying;
    private String[] categoriesPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activiy);

        ListView listViewLearning = findViewById(R.id.list_view_learning);
        listViewPlaying = findViewById(R.id.list_view_playing);

        String[] categoriesLearning = {"Analog ve dijital saat okuma", "Mevsimleri öğrenme", "Gün ve haftaları sırasıyla sayma", "Ayları ve yılları sırasıyla sayma", "Yönleri öğretmek"};
        categoriesPlaying = new String[]{"Sayılarla hafıza oyunu","Sayılarla hafıza geriye doğru",  "Heceleme-yazma oyunu",
                "Çarpma oyunu", "Benzer resimler", "Dolaşan yuvarlak"};

        ArrayAdapter<String> adapterLearning = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriesLearning);
        ArrayAdapter<String> adapterPlaying = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriesPlaying);

        listViewLearning.setAdapter(adapterLearning);
        listViewPlaying.setAdapter(adapterPlaying);

        listViewLearning.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = (String) parent.getItemAtPosition(position);

                if (selectedCategory.equals("Analog ve dijital saat okuma")) {
                    Intent intent = new Intent(CategoryActiviy.this, ClockActivity.class);
                    startActivity(intent);
                } else if (selectedCategory.equals("Mevsimleri öğrenme")) {
                    Intent intent = new Intent(CategoryActiviy.this, SeasonActivity.class);
                    startActivity(intent);
                } else if (selectedCategory.equals("Gün ve haftaları sırasıyla sayma")) {
                    Intent intent = new Intent(CategoryActiviy.this, DaysActivity.class);
                    startActivity(intent);
                } else if (selectedCategory.equals("Ayları ve yılları sırasıyla sayma")) {
                    Intent intent = new Intent(CategoryActiviy.this, MonthsActivity.class);
                    startActivity(intent);
                } else if (selectedCategory.equals("Yönleri öğretmek")) {
                    Intent intent = new Intent(CategoryActiviy.this, DirectionsActivity.class);
                    startActivity(intent);
                }
            }
        });

        listViewPlaying.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categoriesPlaying[position];

                if (selectedCategory.equals("Sayılarla hafıza oyunu")) {
                    startMemoryGame();
                }
                else if (selectedCategory.equals("Sayılarla hafıza geriye doğru")) {
                    Intent intent = new Intent(CategoryActiviy.this, DigitsMemoryGameReverseActivity.class);
                    startActivity(intent);
                }
                else if (selectedCategory.equals("Çarpma oyunu")) {
                    Intent intent = new Intent(CategoryActiviy.this, MultiplexingGameActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void startMemoryGame() {
        // Sayılarla hafıza oyunu aktivitesini başlat
        Intent intent = new Intent(CategoryActiviy.this, DigitsMemoryGameActivity.class);
        startActivity(intent);
    }


}
