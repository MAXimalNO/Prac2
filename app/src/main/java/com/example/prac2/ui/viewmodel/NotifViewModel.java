package com.example.prac2.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.prac2.data.model.Notif;
import com.example.prac2.data.repository.NotifRepository;

import java.util.List;

public class NotifViewModel extends ViewModel {
    public LiveData<List<Notif>> notifs;
    private NotifRepository notifRepository = new NotifRepository();

    public NotifViewModel(){initIt();}
    private void initIt(){
        notifs = notifRepository.getData();
    }
}
