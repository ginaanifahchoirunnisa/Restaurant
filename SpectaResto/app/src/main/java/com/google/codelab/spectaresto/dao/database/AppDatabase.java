package com.google.codelab.spectaresto.dao.database;


import android.content.Context;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.google.codelab.spectaresto.dao.BookmarkDao;
import com.google.codelab.spectaresto.dao.entity.Bookmark;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities={Bookmark.class},version = 2, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {


    public abstract BookmarkDao bookmarkDao();
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "task_table")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                BookmarkDao dao = INSTANCE.bookmarkDao();
               // dao.deleteAll();
            });
        }
    };
}


