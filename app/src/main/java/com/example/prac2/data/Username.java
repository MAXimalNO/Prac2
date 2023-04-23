package com.example.prac2.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usern_table")
public class Username {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user")
    private String usern;

    public Username(){}
    public Username(@NonNull String user) {this.usern = user;}

    @NonNull
    public String getUsern(){return this.usern;}
    public void setUsern(@NonNull String user){this.usern = user;}
}

