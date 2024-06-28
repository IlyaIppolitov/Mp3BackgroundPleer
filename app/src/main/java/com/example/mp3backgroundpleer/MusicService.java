package com.example.mp3backgroundpleer;

import android.app.Service;
import android.content.Intent;
// Библиотека для прогигрывания mp3
import android.media.MediaPlayer;
import android.os.IBinder;
// Добавил логгер для теста
import android.util.Log;

public class MusicService extends Service {

    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.pirates);
        // Повтор трека
        mediaPlayer.setLooping(true);
        Log.d(TAG, "Сервис создан");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Log.d(TAG, "Сервис запущен");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Log.d(TAG, "Сервис остановлен");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}