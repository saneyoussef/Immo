package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.immo.Models.RegisterRequest;
import com.example.immo.Models.RegisterResponse;
import com.example.immo.Models.Role;
import com.example.immo.Service.AuthService;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Indivi_inscrip extends AppCompatActivity {
    private final static String BASE_URL = "http://192.168.1.6:8080/";
    AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indivi_inscrip);
        getSupportActionBar().hide();
        final EditText username = (EditText) findViewById(R.id.name_user);
        final EditText email = (EditText) findViewById(R.id.mail_user);
        final EditText pass = (EditText) findViewById(R.id.pass_user);
        final EditText pass2 = (EditText) findViewById(R.id.pass2user);

        Button inscrit = (Button) findViewById(R.id.user_inscrip);

        inscrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                authService = retrofit.create(AuthService.class);

                if (username.getText().toString().length()<3) {
                    Toast.makeText(getApplicationContext(), "vous devez saisir un nom d'utilisateur valide", Toast.LENGTH_LONG).show();
                }
                String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
                Pattern pattern = Pattern.compile(masque);
                Matcher  controler = pattern.matcher(email.getText().toString());
                if (!controler.matches()){
                    Toast.makeText(getApplicationContext(), "vous devez saisir un mail valide", Toast.LENGTH_LONG).show();}
                 else if (pass.getText().toString().length()<8||pass.getText().toString().length()>15) {
                    Toast.makeText(getApplicationContext(), "le mot de passe doit etre entre 8 et 15 caractéres", Toast.LENGTH_LONG).show();
                } else if (pass2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "vous devez retapez votre mot de passe", Toast.LENGTH_LONG).show();
                }


                else {
                    registerUser(username, email, pass, pass2);
                }
            }

            public void registerUser(TextView username, TextView email, TextView pass, TextView pass2) {
                RegisterRequest registerRequest = new RegisterRequest();
                Role role = new Role();
                Set<Role> roles = new HashSet<>();
                role.setName("USER");
                roles.add(role);
                registerRequest.setUsername(username.getText().toString());
                registerRequest.setPassword(pass.getText().toString());
                registerRequest.setRepeatPassword(pass2.getText().toString());
                registerRequest.setEmail(email.getText().toString());
                registerRequest.setEntreprise(null);
                registerRequest.setPack(null);
                registerRequest.setPhoneNumber(null);
                registerRequest.setType(null);
                registerRequest.setRoles(roles);

                Call<RegisterResponse> response = authService.register(registerRequest);
                response.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if(response.body()==null){
                            Toast.makeText(getApplicationContext(), "les mots de passe ne sont pas identiques", Toast.LENGTH_LONG).show();


                        } else {
                            Intent i = new Intent(Indivi_inscrip.this,LoginActivity.class);
                            startActivity(i);
                        }


                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
