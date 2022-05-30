package com.google.codelab.spectaresto.model.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.google.codelab.spectaresto.dao.BookmarkDao;
import com.google.codelab.spectaresto.dao.database.AppDatabase;
import com.google.codelab.spectaresto.dao.entity.Bookmark;

import java.util.List;

public class BookmarkRepository {
    private BookmarkDao mBookmarkDao;
    AppDatabase appDatabase;
    private LiveData<List<Bookmark>> mAllBookmark;

    BookmarkRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mBookmarkDao = db.bookmarkDao();
        mAllBookmark = mBookmarkDao.getAll();
    }
    LiveData<List<Bookmark>> getmAllBookmarks() {
        return mAllBookmark;
    }

    public void insert(Bookmark bookmark) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mBookmarkDao.addToBookmark(bookmark);
        });

    }

    Bookmark getBookmarkById(int id)
    {

        return appDatabase.bookmarkDao().get(id);

    }

    public void delete(Bookmark bookmark){

    }

}
