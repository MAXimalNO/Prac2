package com.example.prac2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class NotifFragment extends Fragment {

    private ListView lv;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //заполнение данными массива
        for (int i = 1; i < 201; i++){
            list.add("Уведомление " + i);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notif, container, false);

        //Получаем элемент ListView
        lv = view.findViewById(R.id.notiffrg_list);
        //Создаём адаптер
        MyListAdapter mla = new MyListAdapter(view.getContext(),R.layout.list_item,list);
        //Устанавливаем адаптер
        lv.setAdapter(mla);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String notif = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), notif, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}