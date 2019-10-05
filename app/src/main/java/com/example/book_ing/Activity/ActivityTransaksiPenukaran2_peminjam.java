package com.example.book_ing.Activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.book_ing.Adapter.StatusPengirimanAdapter;
import com.example.book_ing.DialogFragmentPilihBuku;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.OtherClass.StatusPengiriman;
import com.example.book_ing.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityTransaksiPenukaran2_peminjam extends AppCompatActivity {

    public static Button buttonPilihBuku;
    public static ConstraintLayout constraintLayoutBukuDipilih;
    public Button buttonLanjutkanResi, buttonStatusTransaksi, buttonTambahHari, buttonKurangHari;
    View sheetView;
    int count = 0;
    AutoCompleteTextView autoCompleteTextViewKota, autoCompleteTextViewKecamatan;
    private int lamaPinjam = 0;
    private int stateButton = 0;
    private EditText editTextResi;
    private TextView textViewResi, textViewLamaPeminjaman, alamatLengkap;
    private RecyclerView statusPengirimanDia, statusPengirimanSaya;
    private Dialog dialogResi;
    private ArrayList<Buku> ListBuku;
    private ArrayList<StatusPengiriman> ListStatusPengiriman;
    private LinearLayout linearLayoutStatusBukuDia, linearLayoutStatusBukuSaya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_penukaran2_peminjam);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        addDataBuku();
        addStatusPengiriman();

        buttonPilihBuku = findViewById(R.id.button_pilih_buku);
        constraintLayoutBukuDipilih = findViewById(R.id.constraintLayout_buku_dipilih);
        linearLayoutStatusBukuDia = findViewById(R.id.linearLayout_status_pengiriman_buku_dia);
        linearLayoutStatusBukuSaya = findViewById(R.id.linearLayout_status_pengiriman_buku_saya);
        buttonLanjutkanResi = findViewById(R.id.button_masuk_resi);
        buttonStatusTransaksi = findViewById(R.id.button_status_transaksi);
        buttonTambahHari = findViewById(R.id.button_tambah_hari);
        alamatLengkap = findViewById(R.id.alamat_lengkap);
        buttonKurangHari = findViewById(R.id.button_kurang_hari);
        textViewLamaPeminjaman = findViewById(R.id.textView_lama_peminjaman);


        buttonTambahHari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamaPinjam++;
                textViewLamaPeminjaman.setText(lamaPinjam + " Hari");
            }
        });

        buttonKurangHari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lamaPinjam--;
                textViewLamaPeminjaman.setText(lamaPinjam + " Hari");
            }
        });

        textViewResi = findViewById(R.id.textView_resi);

        statusPengirimanDia = findViewById(R.id.recyclerview_status_pengiriman_dia);
        statusPengirimanSaya = findViewById(R.id.recyclerview_status_pengiriman_saya);
        autoCompleteTextViewKota = findViewById(R.id.autocompletetext_kota);
        autoCompleteTextViewKecamatan = findViewById(R.id.autocompletetext_kecamatan);

        dialogResi = new Dialog(this);
//        View
        sheetView = this.getLayoutInflater().inflate(R.layout.popup_masukkan_nomer_resi, null);
        buttonLanjutkanResi = sheetView.findViewById(R.id.button_lanjutkan);
        editTextResi = sheetView.findViewById(R.id.editText_resi);

        dialogResi.setContentView(sheetView);
        dialogResi.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        buttonStatusTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityTransaksiPenukaran2_peminjam.this, ActivityTransaksiPenukaran2.class));



            }
        });

//        buttonPilihBuku.setVisibility(View.VISIBLE);
//        linearLayoutStatusBukuDia.setVisibility(View.GONE);
//        linearLayoutStatusBukuSaya.setVisibility(View.GONE);
//        constraintLayoutBukuDipilih.setVisibility(View.GONE);


        final FragmentManager fm = getSupportFragmentManager();
        final DialogFragmentPilihBuku dialogFragmentPilihBuku = new DialogFragmentPilihBuku(ListBuku);


//        buttonPilihBuku.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialogFragmentPilihBuku.show(fm, "Tv Tag");
//
//            }
//        });


        StatusPengirimanAdapter statusPengirimanAdapter = new StatusPengirimanAdapter(ListStatusPengiriman);
        RecyclerView.LayoutManager layoutManagerStatusPengirimanSaya = new LinearLayoutManager(this);
//        statusPengirimanSaya.setLayoutManager(layoutManagerStatusPengirimanSaya);
//        statusPengirimanSaya.setAdapter(statusPengirimanAdapter);
        RecyclerView.LayoutManager layoutManagerStatusPengirimanDia = new LinearLayoutManager(this);
//        statusPengirimanDia.setLayoutManager(layoutManagerStatusPengirimanDia);
//        statusPengirimanDia.setAdapter(statusPengirimanAdapter);


    }

    private void addDataBuku() {

        ListBuku = new ArrayList<>();
        ListBuku.add(new Buku("Bulan", "Rp 10.000", "John Smith", "Muhammad Rizki", "Mojolanggu", "2"));
        ListBuku.add(new Buku("Buku Pintar Microsoft Office 2007 & 2010", "Rp 25.000", "John Smith", "Muhammad Rizki", "Sawojajar", "5"));
        ListBuku.add(new Buku("Revolusi Belum Selesai", "Rp 15.000", "Budi Setiyono", "Muhammad Rizki", "Tlogomas", "4"));
    }

    private void addStatusPengiriman() {

        ListStatusPengiriman = new ArrayList<>();
        ListStatusPengiriman.add(new StatusPengiriman());
        ListStatusPengiriman.add(new StatusPengiriman());

    }

}
