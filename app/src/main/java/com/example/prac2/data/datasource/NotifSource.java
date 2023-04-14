package com.example.prac2.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.prac2.data.model.Notif;

import java.util.ArrayList;
import java.util.List;

public class NotifSource {
    public static LiveData<List<Notif>> createList(){
        MutableLiveData<List<Notif>> list = new MutableLiveData<>();
        ArrayList<Notif> notifs = new ArrayList<>();
        for(int i = 0; i<50; i++){
            Notif not = new Notif("Уведомление"+i, "Текст уведомления "+i, "19.12.2002");
            notifs.add(not);
        }
        list.setValue(notifs);
        return list;
    }
}
