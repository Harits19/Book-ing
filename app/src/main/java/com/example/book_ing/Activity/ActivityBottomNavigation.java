package com.example.book_ing.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.book_ing.Fragment.FragmentAkun;
import com.example.book_ing.Fragment.FragmentBeranda;
import com.example.book_ing.Fragment.FragmentPesan;
import com.example.book_ing.Fragment.FragmentTransaksi;
import com.example.book_ing.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityBottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        loadFragment(new FragmentBeranda());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.beranda_menu:
                fragment = new FragmentBeranda();
                break;
            case R.id.transaksi_menu:
                fragment = new FragmentTransaksi();
                break;
            case R.id.pesan_menu:
                fragment = new FragmentPesan();
                break;
            case R.id.akun_menu:
                fragment = new FragmentAkun();
                break;
        }
        return loadFragment(fragment);
    }
}
