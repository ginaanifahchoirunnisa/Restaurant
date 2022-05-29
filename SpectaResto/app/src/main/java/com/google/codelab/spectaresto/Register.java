package com.google.codelab.spectaresto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.codelab.spectaresto.api.MainInterface;
import com.google.codelab.spectaresto.api.RestClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private EditText uname,pw,email,nohp;
    private TextView notif;
    private MainInterface jsonPlaceHolderApi;
    private Button btn_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uname = findViewById(R.id.edit_text_uname);
        pw = findViewById(R.id.edit_text_pw);
        email = findViewById(R.id.edit_text_email);
        nohp = findViewById(R.id.edit_text_nohp);
        notif = findViewById(R.id.notif);

        btn_regist = findViewById(R.id.button_regist);


        BodyRegister bodyRegister = new BodyRegister();
        bodyRegister.setUsername(uname.getText().toString());
        bodyRegister.setPassword(pw.getText().toString());
        bodyRegister.setEmail(email.getText().toString());
        bodyRegister.setPhoneNumber(nohp.getText().toString());



        //wanna passing gson
//        Gson gson = new GsonBuilder().serializeNulls().create();
//
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        jsonPlaceHolderApi = retrofit.create(MainInterface.class);


        jsonPlaceHolderApi = RestClient.getService();




        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser(bodyRegister);
            }
        });
        //  RegisterUser();
    }

    private void RegisterUser( BodyRegister bodyRegister )
    {


        Call<BodyRegister> call = jsonPlaceHolderApi.createNewUser(bodyRegister);


        call.enqueue(new Callback<BodyRegister>() {
            @Override
            public void onResponse(Call<BodyRegister> call, Response<BodyRegister> response) {
                if(!response.isSuccessful())
                {
                    notif.setText("Code : "+ response.code());
                }
                notif.setText("yeay");
            }

            @Override
            public void onFailure(Call<BodyRegister> call, Throwable t) {
                notif.setText(t.getMessage());
            }
        });

    }


}