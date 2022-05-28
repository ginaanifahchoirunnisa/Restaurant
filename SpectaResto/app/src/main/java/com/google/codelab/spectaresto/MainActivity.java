package com.google.codelab.spectaresto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
}