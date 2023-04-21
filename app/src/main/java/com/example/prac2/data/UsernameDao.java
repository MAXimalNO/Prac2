package com.example.prac2.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsernameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Username usern);

    @Query("DELETE FROM usern_table")
    void deleteAll();

    @Query("SELECT * FROM usern_table ORDER BY user ASC")
    List<Username> getAlphabetizedWords();
}

