package com.example.hoandmph27404.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hoandmph27404.object.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user WHERE id like:id")
    void deleteById(int id);

    @Query("SELECT * FROM user")
    List<User> GetAll();
}
