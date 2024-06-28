package com.example.mp3backgroundpleer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartService = findViewById(R.id.button_start_service);
        Button buttonStopService = findViewById(R.id.button_stop_service);

        buttonStartService.setOnClickListener(v -> {
            Intent startIntent = new Intent(MainActivity.this, MusicService.class);
            startService(startIntent);
        });

        buttonStopService.setOnClickListener(v -> {
            Intent stopIntent = new Intent(MainActivity.this, MusicService.class);
            stopService(stopIntent);
        });
    }
}