package com.example.immo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.immo.Models.RegisterRequest;
import com.example.immo.Models.RegisterResponse;
import com.example.immo.Models.Role;
import com.example.immo.Service.AuthService;

import java.util.HashSet;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Company_inscrip extends AppCompatActivity {

    AuthService authService;
    private RadioButton radiotypeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_inscrip);
        getSupportActionBar().hide();

        //Variables declaration

        final EditText user_company=(EditText) findViewById(R.id.CompanyUser) ;
        final EditText company_name=(EditText) findViewById(R.id.EntreName);
        final EditText company_mail=(EditText) findViewById(R.id.companyMail);
        final EditText company_tel=(EditText) findViewById(R.id.companyTel);
        final EditText company_pass=(EditText) findViewById(R.id.company_password);
        final EditText pass2=(EditText) findViewById(R.id.company_password1);
        Button insc_comp=(Button) findViewById(R.id.inscriptionCompany);

        final RadioGroup type=(RadioGroup) findViewById(R.id.typePack);
        final int selectedId = type.getCheckedRadioButtonId();
        radiotypeButton=(RadioButton) findViewById(selectedId);

        Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
        String[] items= new String[]{"Promoteeur immobilier","Agence immobiliére"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout                     .simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        TextView t1=(TextView) findViewById(R.id.details1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Company_inscrip.this,DetailsBasicActivity.class);
                startActivity(i);
            }
        });
        TextView t2= (TextView) findViewById(R.id.details2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Company_inscrip.this,DetailsGoldActivity.class);
                startActivity(i);
            }
        });
        TextView t3=(TextView) findViewById(R.id.details3);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Company_inscrip.this,DetailsPartnerActivity.class);
                startActivity(i);
            }
        });

        //button register action

        insc_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit =new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                authService= retrofit.create(AuthService.class);
                registerCompany(user_company,company_name,company_mail,company_tel,company_pass,                    selectedId,pass2);

            }

            //register back

            public void registerCompany(TextView user_company,TextView company_name,TextView                     company_mail, TextView company_tel, TextView company_pass, int selectedPack, TextView pass2){

                RegisterRequest registerRequest = new RegisterRequest();
                Role role = new Role();
                Set<Role> roles = new HashSet<>();
                role.setName("PROMOTEUR");
                roles.add(role);
                registerRequest.setUsername(user_company.getText().toString());
                registerRequest.setPassword(company_pass.getText().toString());
                registerRequest.setRepeatPassword(pass2.getText().toString());
                registerRequest.setEmail(company_mail.getText().toString());
                registerRequest.setEntreprise(company_name.getText().toString());
                registerRequest.setPack(RegisterRequest.Pack.BASIC);
                registerRequest.setPhoneNumber(company_tel.getText().toString());
                registerRequest.setType("Gold");
                registerRequest.setRoles(roles);

                Call<RegisterResponse> response = authService.register(registerRequest);
                response.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse>                       response) {
                        if (response.body() != null) {
                            Toast.makeText(getApplicationContext(), "Bienvenue "+response.body().getUsername(), Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Company_inscrip.this,LoginActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Erreur lors du l'inscription", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"" + t.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
