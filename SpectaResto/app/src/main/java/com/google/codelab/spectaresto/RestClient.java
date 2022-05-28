package com.google.codelab.spectaresto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {


    // TODO menginisiasi MainInterface
    private static MainInterface service;

    public static MainInterface getService() {

        if (service == null) {
            // Membuat base URL
            String BASE_URL = "https://documenter.getpostman.com/view/12204297/TVKJwEWL#85736293-0c3e-49ed-a098-dfb69d521de2/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(MainInterface.class);
        }
        return service;
    }


}
