package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView t1=(TextView) findViewById(R.id.tokenData);
        SharedPreferences result=getSharedPreferences("SHARED_PREFS",MODE_PRIVATE);
        String value=result.getString("Token","");
        t1.setText(value);
    }
}
