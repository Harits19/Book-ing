package com.example.book_ing.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_ing.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ActivityDetailBukuPenukaran extends AppCompatActivity {

    private Button buttonObrolan, buttonTukar;
    private ViewGroup Parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        buttonObrolan = findViewById(R.id.button_obrolan);
        buttonTukar = findViewById(R.id.button_);

        buttonObrolan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDetailBukuPenukaran.this, ActivityDetailPesan.class));
            }
        });

        buttonTukar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View modelBottomSheet = LayoutInflater.from(ActivityDetailBukuPenukaran.this).inflate(R.layout.bottom_metode_pengiriman, null);
                BottomSheetDialog dialog = new BottomSheetDialog(ActivityDetailBukuPenukaran.this);
                dialog.setContentView(modelBottomSheet);
                dialog.show();

                Button buttonLanjutkan = modelBottomSheet.findViewById(R.id.button_lanjutkan);
                buttonLanjutkan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ActivityDetailBukuPenukaran.this, ActivityTransaksiPenukaran2.class));

                    }
                });

            }
        });


    }
}
