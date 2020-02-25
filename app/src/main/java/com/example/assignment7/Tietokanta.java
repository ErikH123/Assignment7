package com.example.assignment7;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Data.class}, version = 1, exportSchema = false)
public abstract class Tietokanta extends RoomDatabase {
    public static final String NIMI = "DATABASE";
    public abstract MyDao myDao();
}
