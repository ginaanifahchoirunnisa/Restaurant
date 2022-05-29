package com.google.codelab.spectaresto.api;

import com.google.codelab.spectaresto.BodyRegister;
import com.google.codelab.spectaresto.DataItem;
import com.google.codelab.spectaresto.login.BodyLogin;
import com.google.codelab.spectaresto.login.LoginResponse;
import com.google.codelab.spectaresto.response.ListMenuResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainInterface {
    @POST("auth/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @GET("menu")
    Call<ListMenuResponse> getList();


    @POST("auth/register")
    Call<BodyRegister> createNewUser(@Body BodyRegister bodyRegister);


    @GET("menu?menuname={menuname}")
    Call<ListMenuResponse> searchMenu(@Query("menuname") String menuname);



}
