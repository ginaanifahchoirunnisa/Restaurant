package com.google.codelab.spectaresto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {


    // TODO menginisiasi MainInterface
    private static MainInterface service;

    public static MainInterface getService() {

        if (service == null) {
            // Membuat base URL
            String BASE_URL = "https://foodbukka.herokuapp.com/api/v1/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(MainInterface.class);
        }
        return service;
    }


    public static Retrofit getRetrofit()
    {
        //wanna passing gson
        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://foodbukka.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

//        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        return retrofit;
    }

    public static MainInterface getServices()
    {
        MainInterface userService = getRetrofit().create(MainInterface.class);
        return userService;
    }



}
