package com.example.shortcodemanager.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Code {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String code;

    public Code(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public Code() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
