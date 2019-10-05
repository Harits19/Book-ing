package com.example.book_ing.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Adapter.KatalogAdapter;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityKatalogPeminjaman extends AppCompatActivity {

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
        KatalogAdapter katalogAdapter = new KatalogAdapter(ListKatalogBuku, "peminjaman");
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
        ListKatalogBuku.add(new Buku("Bulan", "Rp 30.000", "Tere Liye", "Asroru Maula", "Lowokwaru", "2", getDrawable(R.drawable.buku)));
        ListKatalogBuku.add(new Buku("Revolusi", "Rp 20.000", "Tan Malaka", "Abhista Maula", "Mojolanggu", "10", getDrawable(R.drawable.buku2)));
        ListKatalogBuku.add(new Buku("Office", "Rp 5.000", "John Smith", "Abdullah Harits", "Mojolanggu", "5", getDrawable(R.drawable.buku1)));
        ListKatalogBuku.add(new Buku("Mantappu Jiwa", "Rp 30.000", "Jerome Polin", "Irwan Kurniawan", "Lowokwaru", "2", getDrawable(R.drawable.buku_mantappu)));
        ListKatalogBuku.add(new Buku("Sebuah Seni Bersikap Bodo Amat", "Rp 20.000", "Tan Malaka", " Asroru Maula", "Mojolanggu", "10", getDrawable(R.drawable.buku_bodo)));
        ListKatalogBuku.add(new Buku("Dilan 1990", "Rp 5.000", "John Smith", "Abhista Maula", "Mojolanggu", "5", getDrawable(R.drawable.buku_dilan1)));
        ListKatalogBuku.add(new Buku("Dilan 1992", "Rp 20.000", "Tan Malaka", "Abdullah Harits", "Mojolanggu", "10", getDrawable(R.drawable.buku_dilan2)));
        ListKatalogBuku.add(new Buku("Milea", "Rp 5.000", "John Smith", "Irwan Kurniawan", "Mojolanggu", "5", getDrawable(R.drawable.buku_dilan3)));
    }
}
