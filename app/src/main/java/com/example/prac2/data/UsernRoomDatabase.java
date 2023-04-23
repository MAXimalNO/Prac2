package com.example.prac2.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Username.class}, version = 1, exportSchema = false)
public abstract class UsernRoomDatabase extends RoomDatabase {

    public abstract  UsernameDao usDao();
    private static volatile UsernRoomDatabase INSTANCE;
    public static UsernRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UsernRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    UsernRoomDatabase.class, "Usern_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}

