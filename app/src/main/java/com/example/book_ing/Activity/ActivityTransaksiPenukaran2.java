package com.example.book_ing.Activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Adapter.KatalogAdapter;
import com.example.book_ing.Adapter.StatusPengirimanAdapter;
import com.example.book_ing.DialogFragmentPilihBuku;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.OtherClass.StatusPengiriman;
import com.example.book_ing.R;

import java.util.ArrayList;

public class ActivityTransaksiPenukaran2 extends AppCompatActivity {

    public static Button buttonPilihBuku;
    public static ConstraintLayout constraintLayoutBukuDipilih;
    public Button buttonMasukResi, buttonStatusTransaksi;
    private RecyclerView statusPengirimanDia, statusPengirimanSaya;
    View sheetView;
    private Dialog dialogResi;
    int count = 0;
    AutoCompleteTextView autoCompleteTextViewKota, autoCompleteTextViewKecamatan;
    private ArrayList<Buku> ListBuku;
    private ArrayList<StatusPengiriman> ListStatusPengiriman;
    private LinearLayout linearLayoutStatusBukuDia, linearLayoutStatusBukuSaya;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_penukaran2);
        addDataBuku();
        addStatusPengiriman();

        buttonPilihBuku = findViewById(R.id.button_pilih_buku);
        constraintLayoutBukuDipilih = findViewById(R.id.constraintLayout_buku_dipilih);
        linearLayoutStatusBukuDia = findViewById(R.id.linearLayout_status_pengiriman_buku_dia);
        linearLayoutStatusBukuSaya = findViewById(R.id.linearLayout_status_pengiriman_buku_saya);
        buttonMasukResi = findViewById(R.id.button_masuk_resi);
        buttonStatusTransaksi = findViewById(R.id.button_status_transaksi);

        statusPengirimanDia = findViewById(R.id.recyclerview_status_pengiriman_dia);
        statusPengirimanSaya = findViewById(R.id.recyclerview_status_pengiriman_saya);
        autoCompleteTextViewKota = findViewById(R.id.autocompletetext_kota);
        autoCompleteTextViewKecamatan = findViewById(R.id.autocompletetext_kecamatan);

        dialogResi =  new Dialog(this);
//        View
        sheetView = this.getLayoutInflater().inflate(R.layout.popup_masukkan_nomer_resi, null);



        buttonMasukResi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogResi.setContentView(sheetView);
                dialogResi.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                dialogResi.show();
            }
        });

        buttonStatusTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutStatusBukuDia.setVisibility(View.VISIBLE);
                linearLayoutStatusBukuSaya.setVisibility(View.VISIBLE);
                buttonStatusTransaksi.setText("Dalam Perjalanan");
                buttonStatusTransaksi.setEnabled(false);
                buttonStatusTransaksi.setBackgroundColor(Color.parseColor("#f0f0f0"));
                buttonStatusTransaksi.setTextColor(Color.parseColor("#000000"));
            }
        });

        buttonPilihBuku.setVisibility(View.VISIBLE);
        buttonMasukResi.setVisibility(View.GONE);
        linearLayoutStatusBukuDia.setVisibility(View.GONE);
        linearLayoutStatusBukuSaya.setVisibility(View.GONE);
        constraintLayoutBukuDipilih.setVisibility(View.GONE);


        final FragmentManager fm = getSupportFragmentManager();
        final DialogFragmentPilihBuku dialogFragmentPilihBuku = new DialogFragmentPilihBuku(ListBuku);


        buttonPilihBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogFragmentPilihBuku.show(fm, "Tv Tag");

            }
        });


        StatusPengirimanAdapter statusPengirimanAdapter = new StatusPengirimanAdapter(ListStatusPengiriman);
        RecyclerView.LayoutManager layoutManagerStatusPengirimanSaya = new LinearLayoutManager(this);
        statusPengirimanSaya.setLayoutManager(layoutManagerStatusPengirimanSaya);
        statusPengirimanSaya.setAdapter(statusPengirimanAdapter);
        RecyclerView.LayoutManager layoutManagerStatusPengirimanDia = new LinearLayoutManager(this);
        statusPengirimanDia.setLayoutManager(layoutManagerStatusPengirimanDia);
        statusPengirimanDia.setAdapter(statusPengirimanAdapter);


    }

    private void addDataBuku() {

        ListBuku = new ArrayList<>();
        ListBuku.add(new Buku("Killing Heningway", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Buku Pintar Microsoft Office 2007 & 2010", "Rp 25.000", "Jarot S.", "Hilmi Aziz", "Sawojajar", "5"));
        ListBuku.add(new Buku("Revolusi Belum Selesai", "Rp 15.000", "Budi Setiyono", "Irwan Kurniawan", "Tlogomas", "4"));
        ListBuku.add(new Buku("Killing HeningwayC", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayD", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayE", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayF", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayG", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Killing HeningwayE", "Rp 10.000", "John Smith", "Abdullah Harits", "Mojolanggu", "2"));

    }

    private void addStatusPengiriman() {

        ListStatusPengiriman = new ArrayList<>();
        ListStatusPengiriman.add(new StatusPengiriman());
        ListStatusPengiriman.add(new StatusPengiriman());

    }

}
