package com.google.codelab.spectaresto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.codelab.spectaresto.dao.BookmarkDao;
import com.google.codelab.spectaresto.dao.database.AppDatabase;
import com.google.codelab.spectaresto.dao.entity.Bookmark;

public class BookmarkActivity extends AppCompatActivity {
    private TextView t_nama, t_deskripsi;

    private AppDatabase database;
    private BookmarkDao bookmarkDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bookmark);
//
//        Intent intent = getIntent();
//        final String nama_produk = intent.getStringExtra("nama_menu");
//        final String deskripsi_menu = intent.getStringExtra("deskripsi_menu");
//
//        final int id = intent.getIntExtra("id", 0);
//
//        Bookmark bookmark = new Bookmark();
//        bookmark.setMenuName(nama_produk);
//        bookmark.setDescription(deskripsi_menu);
//
//        database.bookmarkDao().addToBookmark(bookmark);
//        Toast.makeText(BookmarkActivity.this, "Youve been add the produk to your favorite collection foods!", Toast.LENGTH_SHORT).show();
//
//
//
//

    }
}