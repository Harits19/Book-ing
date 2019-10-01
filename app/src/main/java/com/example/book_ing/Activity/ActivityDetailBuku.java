package com.example.book_ing.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_ing.R;

public class ActivityDetailBuku extends AppCompatActivity {

    private Button buttonObrolan, buttonTukar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        buttonObrolan = findViewById(R.id.button_obrolan);
        buttonTukar = findViewById(R.id.button_tukar);

        buttonObrolan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDetailBuku.this, ActivityDetailPesan.class));
            }
        });

        buttonTukar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDetailBuku.this, ActivityTransaksiPenukaran.class));
            }
        });





    }
}
