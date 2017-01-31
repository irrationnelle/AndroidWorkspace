package net.azurewebsites.irrationnelle.test17service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by irrationnelle on 1/31/17.
 */

public class MusicService extends Service {
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Creating Music", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this, R.raw.donthateme);
        player.setLooping(false);
//        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Starting Music", Toast.LENGTH_SHORT).show();
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Stoping Music", Toast.LENGTH_SHORT).show();
        player.stop();
//        super.onDestroy();
    }
}
