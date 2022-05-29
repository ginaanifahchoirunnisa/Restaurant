package com.google.codelab.spectaresto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.codelab.spectaresto.api.RestClient;
import com.google.codelab.spectaresto.response.ListMenuResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rvListMenu)
    RecyclerView rvListMenu;

    private List<DataItem> listItem;
    private SearchView btn_search;
    private RecyclerAdapter adapter;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn_search = findViewById(R.id.button_search);
        btn_search.clearFocus();
        btn_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);

                return false;
            }
        });

        RestClient.getService().getList().enqueue(new Callback<ListMenuResponse>() {
            @Override
            public void onResponse(Call<ListMenuResponse> call, Response<ListMenuResponse> response) {
                if (response.isSuccessful()){
                    listItem = response.body().getData();

                    adapter = new RecyclerAdapter(listItem, MainActivity.this);
                    rvListMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListMenu.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListMenuResponse> call, Throwable t) {

            }
        });

    }


    private void filterList(String text)
    {
        List<DataItem> filteredList = new ArrayList<>();
        for (DataItem item : listItem)
        {
            if(item.getMenuName().toLowerCase().contains(text.toLowerCase()))
            {
                filteredList.add(item);
            }else if(filteredList.isEmpty())
            {
                Toast.makeText(this,"No data ", Toast.LENGTH_SHORT).show();
            }else{
                adapter.SETFilteredList(filteredList);
            }
        }

    }
}