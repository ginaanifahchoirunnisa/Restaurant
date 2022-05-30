package com.google.codelab.spectaresto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDetails extends AppCompatActivity {
    ViewPager2 viewPager2;
    SliderAdapter sliderAdapter;
    Button btn_add_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_details);

        TextView name = findViewById(R.id.menu_name);
        TextView detail = findViewById(R.id.menu_description);
        btn_add_fav = findViewById(R.id.btn_add_fav);

        Intent intent = getIntent();
        String message = intent.getStringExtra(RecyclerAdapter.EXTRA_MESSAGE);
        //detail.setText(message);

        btn_add_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String message = intent.getStringExtra(RecyclerAdapter.EXTRA_MESSAGE);
            }
        });

        RestClient.getService().getOneMenu(message).enqueue(new Callback<SingleMenuResponse>() {
            @Override
            public void onResponse(Call<SingleMenuResponse> call, Response<SingleMenuResponse> response) {
                if (response.isSuccessful()){
                    // image slider
                    viewPager2 = findViewById(R.id.viewPager2);
                    sliderAdapter = new SliderAdapter(response.body().getResult().getImages(), MenuDetails.this);
                    viewPager2.setAdapter(sliderAdapter);

                    String menuName = response.body().getResult().getMenuName();
                    String desc = response.body().getResult().getDescription();
                    int v = response.body().getResult().getV();
                    name.setText(menuName);
                    detail.setText(desc);

                    btn_add_fav.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<SingleMenuResponse> call, Throwable t) {

            }
        });
    }
}
