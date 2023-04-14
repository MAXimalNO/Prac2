package com.example.prac2.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prac2.R;
import com.example.prac2.ui.adapter.MyListAdapter;
import com.example.prac2.ui.viewmodel.NotifViewModel;

import java.util.ArrayList;


public class NotifFragment extends Fragment {

    private ListView lv;
    private ArrayList<String> list = new ArrayList<>();
    private NotifViewModel notifViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notifViewModel = new ViewModelProvider(this).get(NotifViewModel.class);

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
        //Подписка на изменения
        notifViewModel.notifs.observe(getViewLifecycleOwner(), notifs -> mla.updateNotifs(notifs));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String notif = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), notif, Toast.LENGTH_SHORT).show();
                Log.i("ListView",notif);
            }
        });

        return view;
    }

}