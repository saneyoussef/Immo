package com.example.immo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class inscription extends AppCompatActivity {

   private TabLayout tabLayout ;
   private AppBarLayout appBarLayout ;
   private ViewPager viewPager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        getSupportActionBar().hide();
        tabLayout = (TabLayout) findViewById(R.id.tablayoutid);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpagerid);
        ViewPagerAdapterinscri adapter = new ViewPagerAdapterinscri(getSupportFragmentManager());
        adapter.AddFragment(new FragmentIndiv(),"individuel");
        adapter.AddFragment(new FragmentCompagnie(),"compagnie");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
