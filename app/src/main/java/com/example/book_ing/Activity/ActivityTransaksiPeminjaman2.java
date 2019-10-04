package com.example.book_ing.Activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.example.book_ing.DialogFragmentPilihBuku;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.util.ArrayList;

public class ActivityTransaksiPeminjaman2 extends AppCompatActivity {

    public static Button buttonPilihBuku;
    public static ConstraintLayout constraintLayoutBukuDipilih;
    public Button buttonMasukResi, buttonStatusTransaksi;
    View sheetView;
    int count = 0;
    AutoCompleteTextView autoCompleteTextViewKota, autoCompleteTextViewKecamatan;
    private Dialog dialogResi;
    private ArrayList<Buku> ListBuku;
    private LinearLayout linearLayoutStatusBukuDia, linearLayoutStatusBukuSaya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_peminjaman2);
//        addDataBuku();

//        constraintLayoutBukuDipilih = findViewById(R.id.constraintLayout_buku_dipilih);
//        linearLayoutStatusBukuDia = findViewById(R.id.linearLayout_status_pengiriman_buku_dia);
//        linearLayoutStatusBukuSaya = findViewById(R.id.linearLayout_status_pengiriman_buku_saya);
//        buttonMasukResi = findViewById(R.id.button_masuk_resi);
//        buttonStatusTransaksi = findViewById(R.id.button_status_transaksi);

//        final FragmentManager fm = getSupportFragmentManager();
//        final DialogFragmentPilihBuku dialogFragmentPilihBuku = new DialogFragmentPilihBuku(ListBuku);

//        buttonMasukResi.setVisibility(View.GONE);
//        linearLayoutStatusBukuDia.setVisibility(View.GONE);
//        linearLayoutStatusBukuSaya.setVisibility(View.GONE);
//        constraintLayoutBukuDipilih.setVisibility(View.GONE);


//        sheetView = this.getLayoutInflater().inflate(R.layout.popup_pilih_kurir, null);
//
//
//        autoCompleteTextViewKota = findViewById(R.id.autocompletetext_kota);
//        autoCompleteTextViewKecamatan = findViewById(R.id.autocompletetext_kecamatan);
//
//
//        dialogResi = new Dialog(this);
//        sheetView = this.getLayoutInflater().inflate(R.layout.popup_masukkan_nomer_resi, null);
//
//        buttonMasukResi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogResi.setContentView(sheetView);
//                dialogResi.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
//                dialogResi.show();
//            }
//        });
//
//
//        buttonPilihBuku.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialogFragmentPilihBuku.show(fm, "Tv Tag");
//
//            }
//        });


    }

    private void addDataBuku() {

        ListBuku = new ArrayList<>();
        ListBuku.add(new Buku("Killing Heningway", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayA", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayB", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayC", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayD", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayE", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayF", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayG", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayE", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));

    }

}
