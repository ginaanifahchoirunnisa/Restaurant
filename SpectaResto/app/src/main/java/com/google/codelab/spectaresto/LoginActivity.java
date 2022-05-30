package com.google.codelab.spectaresto;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.codelab.spectaresto.view.register.Register;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
LoginActivity extends AppCompatActivity {
   // @BindView(R.id.edit_text_username)
    public EditText edtEmail;
  //  @BindView(R.id.edit_text_password)
  public EditText edtPassword;
  public TextView msgn;
   // @BindView(R.id.btn_go_to_login)
   public Button btnLogin, btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        edtEmail = findViewById(R.id.edit_text_username);
        edtPassword = findViewById(R.id.edit_text_password);
        btnLogin = findViewById(R.id.button_login);
        msgn = findViewById(R.id.msg);


        btn_register = findViewById(R.id.button_register_page);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotopageregister = new Intent(LoginActivity.this, Register.class);
                startActivity(gotopageregister);
            }
        });
    }

    @OnClick(R.id.button_login)
    public void onViewClicked() {

        BodyLogin bodyLogin =  new BodyLogin();
        bodyLogin.setUsername(edtEmail.getText().toString());
        bodyLogin.setPassword(edtPassword.getText().toString());


        RestClient.getService().postLogin(bodyLogin).enqueue(new Callback<LoginResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                    Log.i("Response", response.message());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }else{
                    String msgs = "Login berhasil";
                    Toast.makeText(LoginActivity.this,msgs,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String msgs = "Email ";
                Toast.makeText(LoginActivity.this,msgs,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}