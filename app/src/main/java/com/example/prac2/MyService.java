package com.example.prac2;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyService extends Service {

    private View BannerView;
    private WindowManager winManager;
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

        // Создаем визуальный элемент для баннера
        BannerView = LayoutInflater.from(this).inflate(R.layout.banner, null);

        // Инициализируем WindowManager
        winManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // Определяем параметры для размещения баннера
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        // Устанавливаем позицию баннера
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        params.y = 100;

        // Создаем PendingIntent для перехода в запущенное приложение
        Intent appIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, appIntent, 0);

        //Запрос разрешения
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent2 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent2);
        } else {
            // Разрешение уже получено, отобразить баннер
            winManager.addView(BannerView, params);
        }

        // Добавляем возможность перехода в запущенное приложение при клике на баннер
        BannerView.setOnClickListener(v -> {
            try {
                pendingIntent.send();
                onDestroy();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        });

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i("Serv","Serv destroy");
        super.onDestroy();

        // Удаляем баннер с экрана при завершении сервиса
        if (BannerView != null) {
            winManager.removeView(BannerView);
        }
    }


}