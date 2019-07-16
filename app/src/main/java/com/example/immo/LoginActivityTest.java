package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivityTest extends AppCompatActivity {

    private static final String TAG = "LoginActicity";
    private static final int REQUEST_SIGNUP=0;

    EditText mail;
    EditText password1;
    Button login;
    TextView singupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);

         mail= (EditText) findViewById(R.id.inputEmail);
         password1=(EditText) findViewById(R.id.inputPassword);
        login = (Button) findViewById(R.id.btnLogin);
        singupLink =(TextView) findViewById(R.id.link_signup);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }

            });

            singupLink.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Start the Signup activity
                    Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                    startActivityForResult(intent, REQUEST_SIGNUP);
                }
            });
        }

        public void login() {
            Log.d(TAG, "Login");

            if (!validate()) {
                onLoginFailed();
                return;
            }

            login.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(LoginActivityTest.this,
                    R.style.Theme_AppCompat_DayNight_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating...");
            progressDialog.show();

            String email = mail.getText().toString();
            String password = password1.getText().toString();

            // TODO: Implement your own authentication logic here.

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
                            onLoginSuccess();
                            // onLoginFailed();
                            progressDialog.dismiss();
                        }
                    }, 3000);
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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

        public void onLoginSuccess() {
            login.setEnabled(true);
            finish();
        }

        public void onLoginFailed() {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

            login.setEnabled(true);
        }

        public boolean validate() {
            boolean valid = true;

            String email = mail.getText().toString();
            String password = password1.getText().toString();

            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                mail.setError("enter a valid email address");
                valid = false;
            } else {
                mail.setError(null);
            }

            if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                password1.setError("between 4 and 10 alphanumeric characters");
                valid = false;
            } else {
                password1.setError(null);
            }

            return valid;
        }


}
