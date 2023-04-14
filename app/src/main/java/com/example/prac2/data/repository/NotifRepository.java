package com.example.prac2.data.repository;

import androidx.lifecycle.LiveData;

import com.example.prac2.data.datasource.NotifSource;
import com.example.prac2.data.model.Notif;

import java.util.List;

public class NotifRepository {
    private LiveData<List<Notif>> notifs;

    public NotifRepository(){notifs = NotifSource.createList();}

    public LiveData<List<Notif>> getData(){return notifs;}
}
