package com.example.hoandmph27404.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hoandmph27404.object.User;

@Database(entities = {User.class},version=1)
public abstract class UserDatabase extends RoomDatabase {
    public static final String DATABASENAME="user.db";

    public abstract UserDAO userDAO();
    public static UserDatabase Instance;
    public static synchronized UserDatabase getInstance(Context context){
       if (Instance==null){
           Instance= Room.databaseBuilder(context,UserDatabase.class,DATABASENAME).allowMainThreadQueries().build();
       }
       return Instance;
    }

}
