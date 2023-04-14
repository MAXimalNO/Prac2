package com.example.prac2.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prac2.R;
import com.example.prac2.data.model.Notif;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends ArrayAdapter<Notif> {
    private LayoutInflater inflater;
    private int layout;
    private List<Notif> items;

    public MyListAdapter(Context context, int resource, List<Notif> items) {
        super(context, resource, items);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.items = items;
    }

    public View getView(int position, View convertView,ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.list_txt);
        String item = items.get(position).getTitle();
        textView.setText(item);
        return view;
    }

    public void updateNotifs(List<Notif> notifs) {
        items = notifs;
    }
}

