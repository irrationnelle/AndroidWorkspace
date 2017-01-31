package net.azurewebsites.irrationnelle.test17service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/31/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnMusicStart;
    private Button btnMusicStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMusicStart = (Button) findViewById(R.id.btn_music_start);
        btnMusicStop = (Button) findViewById(R.id.btn_music_stop);

        btnMusicStart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            startService(intent); // 서비스 실행 인텐트 보내기
        });

        btnMusicStop.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            stopService(intent); // 서비스 종료 인텐트 보내기
        });
    }
}
