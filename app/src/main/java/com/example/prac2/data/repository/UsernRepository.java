package com.example.prac2.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.prac2.data.UsernRoomDatabase;
import com.example.prac2.data.Username;
import com.example.prac2.data.UsernameDao;

import java.util.List;

public class UsernRepository {
    public UsernameDao usDao;

    public UsernRepository(Context context){
        UsernRoomDatabase db = UsernRoomDatabase.getDatabase(context);
        usDao = db.usDao();
    }

    public LiveData<List<Username>> getUsern(){
        return usDao.getAllUsern();
    }
}


