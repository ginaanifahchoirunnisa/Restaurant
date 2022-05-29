package com.google.codelab.spectaresto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private RecyclerAdapter adapter;
    private EditText edt_search;
    private Button btn_cari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//
//        edt_search = findViewById(R.id.cari);
//        btn_cari = findViewById(R.id.btn_search);
//        String searching_key = edt_search.getText().toString().trim();
//
//        btn_cari.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
////                startActivity(intent);
//                RestClient.getService().getList("Meatballs").enqueue(new Callback<ListMenuResponse>() {
//                    @Override
//                    public void onResponse(Call<ListMenuResponse> call, Response<ListMenuResponse> response) {
//                        if (response.isSuccessful()){
//                            listItem = response.body().getData();
//
//                            adapter = new RecyclerAdapter(listItem, MainActivity.this);
//                            rvListMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                            rvListMenu.setAdapter(adapter);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ListMenuResponse> call, Throwable t) {
//
//                    }
//                });
//
//            }
//        });
//
//
//


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.data_menu,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}