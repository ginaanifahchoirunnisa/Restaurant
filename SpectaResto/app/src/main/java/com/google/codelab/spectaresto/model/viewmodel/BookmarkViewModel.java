package com.google.codelab.spectaresto.model.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.work.WorkManager;
import com.google.codelab.spectaresto.dao.entity.Bookmark;
import java.util.List;


public class BookmarkViewModel extends AndroidViewModel {
    private BookmarkRepository mRepository;
    private LiveData<List<Bookmark>> mAllBookmark;
    private WorkManager workManager;
    private static final String TAG = BookmarkViewModel.class.getSimpleName();

    public BookmarkViewModel (@NonNull Application application) {
        super(application);
        mRepository = new BookmarkRepository(application);
        mAllBookmark = mRepository.getmAllBookmarks();
        workManager = WorkManager.getInstance(application);
    }


    LiveData<List<Bookmark>> getAllBookmark() {
        return mAllBookmark;
    }

    @SuppressLint("RestrictedApi")
    public void insert(Bookmark bookmark) {
        mRepository.insert(bookmark);
    }
}
