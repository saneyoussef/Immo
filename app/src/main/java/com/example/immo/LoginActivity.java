package com.example.immo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.immo.Models.JwtRequest;
import com.example.immo.Models.JwtResponse;
import com.example.immo.Service.AuthService;

public class LoginActivity extends AppCompatActivity {

    AuthService authService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        final TextView username=(TextView) findViewById(R.id.input_email);
        final TextView password=(TextView) findViewById(R.id.input_password);
        Button login=(Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit =new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                authService= retrofit.create(AuthService.class);
                //getPosts();
                //getComments();
                authenticateUser(username, password);
               /** Intent i=new Intent(LoginActivity.this,AcceuilActivity.class);
                startActivity(i);**/

            }

            private void authenticateUser(TextView username, TextView password) {
                JwtRequest jwtRequest = new JwtRequest();
                jwtRequest.setUsername(username.getText().toString());
                jwtRequest.setPassword(password.getText().toString());

                Call<JwtResponse> response = authService.authenticate(jwtRequest);
                response.enqueue(new Callback<JwtResponse>() {
                    @Override
                    public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                        Toast.makeText(getApplicationContext(),"" + response.body().getJwttoken(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<JwtResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"" + t.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
