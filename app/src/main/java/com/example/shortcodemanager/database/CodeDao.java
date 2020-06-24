package com.example.shortcodemanager.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shortcodemanager.model.Code;

import java.util.List;

@Dao
public interface CodeDao {

    @Insert
    void insertCode(Code code);

    @Query("SELECT * FROM `Code`")
    LiveData<List<Code>> fetchCodes();
}
