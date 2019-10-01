package com.example.book_ing.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.book_ing.Adapter.BukuAdapter;
import com.example.book_ing.Adapter.KatalogAdapter;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityKatalog extends AppCompatActivity {

    private RecyclerView RecyclerViewKatalog;
    private ArrayList<Buku> ListKatalogBuku;

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
        KatalogAdapter katalogAdapter = new KatalogAdapter(ListKatalogBuku);
//        RecyclerView.LayoutManager layoutManagerBerita = new LinearLayoutManager(this);
        RecyclerViewKatalog.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerViewKatalog.setAdapter(katalogAdapter);


    }

    private void addDataBuku() {

        ListKatalogBuku = new ArrayList<>();
        ListKatalogBuku.add(new Buku("Killing Heningway", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayA", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayB", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayC", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayD", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayE", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayF", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayG", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListKatalogBuku.add(new Buku("Killing HeningwayE", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));

    }
}
