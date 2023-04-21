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
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static UsernRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UsernRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    UsernRoomDatabase.class, "Usern_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
