package com.example.prac2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    private ArrayList<String> list = new ArrayList<>();
    //Идентификатор уведомления
    private static final int NOTIFY_ID = 123;
    //Идентификатор канала
    private static String CHANNEL_ID = "ChatMes";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //заполнение данными массива
        for (int i = 1; i < 201; i++) {
            list.add("Сообщение " + i);
        }

        // Создание канала если API>=26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Chan1";
            String description = "Chan1desc";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        //Получаем элемент RecyclerView
        RecyclerView rv = view.findViewById(R.id.chatfrg_list);
        //Создаём адаптер
        MyRecyclerAdapter mra = new MyRecyclerAdapter(getContext(), list);
        //Устанавливаем адаптер
        rv.setAdapter(mra);

        //Кнопка для уведомления
        Button bt = view.findViewById(R.id.chatfrg_btnUved);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                                .setSmallIcon(R.drawable.vopros)
                                .setContentTitle("Уведомление")
                                .setContentText("Кол-во сообщений " + list.size())
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(getContext());


                //Условие того, что разрешение было предоставлено
                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.POST_NOTIFICATIONS)
                        == PackageManager.PERMISSION_GRANTED) {
                    notificationManager.notify(NOTIFY_ID, builder.build());
                }
            }
        });

        return view;
    }



}