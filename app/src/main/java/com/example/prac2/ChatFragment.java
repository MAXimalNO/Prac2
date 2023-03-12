package com.example.prac2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //заполнение данными массива
        for (int i = 1; i < 201; i++){
            list.add("Сообщение " + i);
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
        MyRecyclerAdapter mra = new MyRecyclerAdapter(getContext(),list);
        //Устанавливаем адаптер
        rv.setAdapter(mra);

        return view;
    }
}