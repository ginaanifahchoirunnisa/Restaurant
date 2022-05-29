package com.google.codelab.spectaresto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainInterface {
    @POST("auth/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @GET("menu")
    Call<ListMenuResponse> getList();

    @GET("menu/{id}")
    Call<SingleMenuResponse> getOneMenu(@Path("id") String postId);

    @GET("menu")
    Call<ListMenuResponse> getList(@Query("menuname") String menuName);


}
