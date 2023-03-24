package com.example.prac2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
         Log.i("Serv","Serv creat");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Serv","Serv onStart");
        //Останавливаем сервис
        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i("Serv","Serv destroy");
        super.onDestroy();
    }
}