package kr.co.musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MusicService";
    MediaPlayer player;



    public MyService() {
    }

    //서비스가 처음으로 실행되면 음악 재생기를 생성함
    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate()");


        player = MediaPlayer.create(this,R.raw.dbd);
        player.setLooping(false);

        super.onCreate();
    }

    @Override
    public void onDestroy() {

        Log.d(TAG,"onDestroy()");
        Toast.makeText(this, "Music Service가 중지됨", Toast.LENGTH_SHORT).show();
        player.stop();

        super.onDestroy();
    }

    //서비스가 시작될때마다 음악 재생 시작
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand()");
        Toast.makeText(this, "Music Service가 시작됨", Toast.LENGTH_SHORT).show();
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}