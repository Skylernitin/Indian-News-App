package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.widget.*;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.*;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tabitem_home, tabitem_sport, tabitem_health, tabitem_science, tabitem_entertainment, tabitem_technology;
    Toolbar mtoolbar;
    PagerAdapter pagerAdapter;
    String api = "12baccdd6cac464abff9aa7301029fc5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar = findViewById(R.id.mtoolbar);
        setSupportActionBar(mtoolbar);

        tabitem_home = findViewById(R.id.tabitem_home);
        tabitem_sport = findViewById(R.id.tabitem_sport);
        tabitem_health = findViewById(R.id.tabitem_health);
        tabitem_science = findViewById(R.id.tabitem_science);
        tabitem_entertainment = findViewById(R.id.tabitem_entertainment);
        tabitem_technology = findViewById(R.id.tabitem_technology);
        tabLayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.fragmentcontainer);

        //pagerAdapter is class object
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6); //6 number of fragments
        viewPager.setAdapter(pagerAdapter);

        //user click directly on random fragment
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //user swipe the fragment
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}