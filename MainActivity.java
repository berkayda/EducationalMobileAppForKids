package com.example.sunumdeneme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    // Basit bir kontrol için bir 'database' benzeri yapı
    private String storedUsername = "abcd";
    private String storedPassword = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storedUsername = username.getText().toString();
                storedPassword = password.getText().toString();

                Toast.makeText(MainActivity.this, "Başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword)) {
                    Toast.makeText(MainActivity.this, "Başarıyla giriş yapıldı!", Toast.LENGTH_SHORT).show();

                    // CategoryActivity'yi aç
                    Intent intent = new Intent(MainActivity.this, CategoryActiviy.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Geçersiz kullanıcı adı veya şifre!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
