package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.florescu.android.rangeseekbar.RangeSeekBar;

public class SearchActivity extends AppCompatActivity {

    RangeSeekBar rangeSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rangeSeekBar=(RangeSeekBar) findViewById(R.id.surface_bar);
        getSupportActionBar().hide();

        rangeSeekBar.setRangeValues(0,50);
        rangeSeekBar.setSelectedMaxValue(50);
        rangeSeekBar.setSelectedMinValue(0);

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {
                Number  max_value= bar.getSelectedMaxValue();
                Number min_value =bar.getSelectedMinValue();

                int min=(int) min_value;
                int max=(int) max_value;

                Toast.makeText(getApplicationContext(),"Min"+min+ "\n"+"Max"+max,Toast.LENGTH_LONG).show();
            }
        });
    }

    }

