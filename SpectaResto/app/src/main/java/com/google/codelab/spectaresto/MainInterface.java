package com.google.codelab.spectaresto;

import com.google.codelab.spectaresto.model.register.BodyRegister;
import com.google.codelab.spectaresto.view.register.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MainInterface {
    @POST("auth/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @GET("menu")
    Call<ListMenuResponse> getList();

    @GET("menu/{id}")
    Call<SingleMenuResponse> getOneMenu(@Path("id") String postId);

    @POST("auth/register")
    Call<Register> postRegister(@Body BodyRegister bodyRegister);




}
