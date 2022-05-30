package com.google.codelab.spectaresto.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.google.codelab.spectaresto.dao.entity.Bookmark;

import java.util.List;

@Dao
public interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addToBookmark(Bookmark bookmark);

    @Query("SELECT * from bookmark_table")
    LiveData<List<Bookmark>> getAll();

    //get satu data
    @Query("SELECT * from bookmark_table WHERE id = :id")
    Bookmark get(int id);


}
