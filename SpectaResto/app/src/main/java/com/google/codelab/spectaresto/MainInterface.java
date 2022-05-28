package com.google.codelab.spectaresto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MainInterface {
    @POST("api/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

}
