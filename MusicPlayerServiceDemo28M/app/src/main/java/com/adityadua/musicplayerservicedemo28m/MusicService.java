package com.adityadua.musicplayerservicedemo28m;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by AdityaDua on 07/05/18.
 */

public class MusicService extends Service {

    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mp = MediaPlayer.create(getApplicationContext(),R.raw.ashq);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        mp.setLooping(true);

        // To be explained START_STICKY
        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        if(mp.isPlaying()){
            mp.pause();
        }

        super.onDestroy();
    }
}
