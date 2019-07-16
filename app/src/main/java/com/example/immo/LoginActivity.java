package com.example.immo;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.immo.Models.JwtRequest;
import com.example.immo.Models.JwtResponse;
import com.example.immo.Service.AuthService;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.JsonIOException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActicity";
    private static final int REQUEST_SIGNUP = 0;

    EditText username;
    EditText password;
    Button login;
    TextView noAccount;
    TextView reset;

    private LoginButton loginFb;
    private CallbackManager callbackManager;
    AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        login = (Button) findViewById(R.id.login_btn);
        noAccount=(TextView) findViewById(R.id.link_signup);
        reset=(TextView) findViewById(R.id.reset_password);
        loginFb=(LoginButton) findViewById(R.id.login_button);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this,ResetPasswordActivity.class);
                startActivity(i);
            }
        });




        final String NAME = "name";

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,S_inscrireActivity.class);
                startActivity(i);
            }
        });


      login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Login");

                if (!validate()) {
                    onLoginFailed();
                    return;
                }
                //login.setEnabled(false);
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                        R.style.Theme_AppCompat_DayNight_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();

                //String email = username.getText().toString();
                //String password = password1.getText().toString();

                // TODO: Implement your own authentication logic here.

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed
                                //onLoginSuccess();
                                // onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 3000);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                authService = retrofit.create(AuthService.class);


                authenticateUser(username, password);





            }

            private void authenticateUser(EditText username, EditText password) {
                JwtRequest jwtRequest = new JwtRequest();
                jwtRequest.setUsername(username.getText().toString());
                jwtRequest.setPassword(password.getText().toString());

                Call<JwtResponse> response= authService.authenticate(jwtRequest);
                response.enqueue(new Callback<JwtResponse>() {
                    @Override
                    public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {
                        if (response.body() != null) {
                            SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putString("Token", response.body().getJwttoken());
                            editor.commit();
                            Intent i=new Intent(LoginActivity.this,AcceuilActivity.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(getApplicationContext(), "Email ou mot de passe incorrectes" , Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<JwtResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "fuuuuck" , Toast.LENGTH_LONG).show();

                    }
                });

               /** Call<JwtResponse> response = authService.authenticate(jwtRequest);
                response.enqueue(new Callback<JwtResponse>() {
                    @Override
                    public void onResponse(Call<JwtResponse> call, Response<JwtResponse> response) {



                        Intent i=new Intent(LoginActivity.this,AcceuilActivity.class);
                        startActivity(i);

                    }

                    @Override
                    public void onFailure(Call<JwtResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "fuuuuck" , Toast.LENGTH_LONG).show();

                    }
                });**/
            }
        });



        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }

        }

    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }
    //public void onLoginSuccess() {
        //login.setEnabled(true);
    //}**/
    public void onLoginFailed() {

        login.setEnabled(true);
    }
    public boolean validate() {
        boolean valid = true;

        String email = username.getText().toString();
        String password1 = password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            username.setError("enter a valid email address");
            valid = false;
        } else {
            username.setError(null);
        }

        if (password1.isEmpty() || password.length() < 4 || password.length() > 10) {
            password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }
}
