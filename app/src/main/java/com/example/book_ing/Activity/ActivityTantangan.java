package com.example.book_ing.Activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.book_ing.Adapter.TabLayoutTantanganAdapter;
import com.example.book_ing.R;
import com.google.android.material.tabs.TabLayout;

public class ActivityTantangan extends AppCompatActivity {

    private TabLayout TabLayoutTantangan;
    private ViewPager ViewPagerTantangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tantangan);

        TabLayoutTantangan = findViewById(R.id.tablayout_tantangan);

        TabLayoutTantangan.addTab(TabLayoutTantangan.newTab().setText("Tantangan"));
        TabLayoutTantangan.addTab(TabLayoutTantangan.newTab().setText("Tantangan Saya"));
        ViewPagerTantangan= findViewById(R.id.viewpager_transaksi);


        TabLayoutTantanganAdapter adapter = new TabLayoutTantanganAdapter(this, getSupportFragmentManager(), TabLayoutTantangan.getTabCount());
        ViewPagerTantangan.setAdapter(adapter);
        ViewPagerTantangan.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TabLayoutTantangan));

        TabLayoutTantangan.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ViewPagerTantangan.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}
