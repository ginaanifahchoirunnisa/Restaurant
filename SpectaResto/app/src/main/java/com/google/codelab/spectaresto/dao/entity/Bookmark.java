package com.google.codelab.spectaresto.dao.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "bookmark_table")
public class Bookmark {

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo
    private String menuName;

    @ColumnInfo
    private String description;


    public int getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }




}
