package com.example.book_ing.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.book_ing.Adapter.KatalogAdapter;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityKatalogPenukaran extends AppCompatActivity {

    private RecyclerView RecyclerViewKatalog;
    private ArrayList<Buku> ListKatalogBuku;
    private TabLayout tabLayoutKategori;

        @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);


        addDataBuku();
        RecyclerViewKatalog = findViewById(R.id.recyclerview_katalog);
        KatalogAdapter katalogAdapter = new KatalogAdapter(ListKatalogBuku, "penukaran");
        RecyclerViewKatalog.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerViewKatalog.setAdapter(katalogAdapter);

        //Konfigurasi TabLayout
        tabLayoutKategori = findViewById(R.id.tabLayout_kategori);
        tabLayoutKategori.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayoutKategori.addTab(tabLayoutKategori.newTab().setText("Semua"));
        tabLayoutKategori.addTab(tabLayoutKategori.newTab().setText("Biografi"));
        tabLayoutKategori.addTab(tabLayoutKategori.newTab().setText("Ilmiah"));
        tabLayoutKategori.addTab(tabLayoutKategori.newTab().setText("Novel"));
        tabLayoutKategori.addTab(tabLayoutKategori.newTab().setText("Tafsir"));



    }

    private void addDataBuku() {

        ListKatalogBuku = new ArrayList<>();
        ListKatalogBuku.add(new Buku("Killing Heningway", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2", getDrawable(R.drawable.buku)));
        ListKatalogBuku.add(new Buku("Killing Heningway", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2", getDrawable(R.drawable.buku2)));
        ListKatalogBuku.add(new Buku("Killing Heningway", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2", getDrawable(R.drawable.buku1)));


    }
}
