package com.google.codelab.spectaresto.view.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.codelab.spectaresto.LoginActivity;
import com.google.codelab.spectaresto.MainInterface;
import com.google.codelab.spectaresto.R;
import com.google.codelab.spectaresto.RegisterResponse;
import com.google.codelab.spectaresto.RestClient;
import com.google.codelab.spectaresto.model.register.BodyRegister;


import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private EditText uname, pw, email, nohp;
    private TextView notif;
    private MainInterface jsonPlaceHolderApi;
    private Button btn_regist;
    private BodyRegister bdregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        uname = findViewById(R.id.edit_text_uname);
        pw = findViewById(R.id.edit_text_pw);
        email = findViewById(R.id.edit_text_email);
        nohp = findViewById(R.id.edit_text_nohp);
        notif = findViewById(R.id.notif);

        btn_regist = findViewById(R.id.button_regist);
    }


    @OnClick(R.id.button_regist)
    public void onViewClicked() {

        BodyRegister bodyRegister =  new BodyRegister();
        bodyRegister.setUsername(uname.getText().toString());
        bodyRegister.setPassword(pw.getText().toString());
        bodyRegister.setPhoneNumber(nohp.getText().toString());
        bodyRegister.setEmail(email.getText().toString());

        RestClient.getServices().postRegister(bodyRegister).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful())
                {
                    String msgs = "success ... ";
                    Toast.makeText(Register.this,msgs,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this, LoginActivity.class));
                }else{
                    String msgs = "An error occured please try again later ... ";
                    Toast.makeText(Register.this,msgs,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });

    }



}