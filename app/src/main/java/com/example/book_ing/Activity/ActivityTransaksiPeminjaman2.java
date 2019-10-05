package com.example.book_ing.Activity;

import android.app.ActionBar;
import android.app.Dialog;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Adapter.StatusPengirimanAdapter;
import com.example.book_ing.DialogFragmentPilihBuku;
import com.example.book_ing.OtherClass.StatusPengiriman;
import com.example.book_ing.R;

import java.util.ArrayList;

public class ActivityTransaksiPeminjaman2 extends AppCompatActivity {


    public Button buttonLanjutkanResi, buttonStatusTransaksi, buttonTambahHari, buttonKurangHari;
    View sheetView;
    Dialog dialogResi;
    int count = 0;
    AutoCompleteTextView autoCompleteTextViewKota, autoCompleteTextViewKecamatan;
    private int lamaPinjam = 0;
    private int stateButton = 0;
    private EditText editTextResi;
    private TextView textViewResi, textViewLamaPeminjaman, alamatLengkap;
    private RecyclerView statusPengiriman;
    private ArrayList<StatusPengiriman> ListStatusPengiriman;
    private LinearLayout linearLayoutStatusBuku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_peminjaman2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        addStatusPengiriman();

        linearLayoutStatusBuku = findViewById(R.id.linearLayout_status_pengiriman_buku_saya);
        buttonLanjutkanResi = findViewById(R.id.button_masuk_resi);
        buttonStatusTransaksi = findViewById(R.id.button_status_transaksi);
        buttonTambahHari = findViewById(R.id.button_tambah_hari);
        buttonKurangHari = findViewById(R.id.button_kurang_hari);
        textViewLamaPeminjaman = findViewById(R.id.textView_lama_peminjaman);
        statusPengiriman = findViewById(R.id.recyclerview_status_pengiriman_saya);
        autoCompleteTextViewKota = findViewById(R.id.autocompletetext_kota);
        autoCompleteTextViewKecamatan = findViewById(R.id.autocompletetext_kecamatan);
        textViewResi = findViewById(R.id.textView_resi);
        alamatLengkap = findViewById(R.id.alamat_lengkap);



//        buttonTambahHari.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lamaPinjam++;
//                textViewLamaPeminjaman.setText(lamaPinjam + " Hari");
//            }
//        });
//
//        buttonKurangHari.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lamaPinjam--;
//                textViewLamaPeminjaman.setText(lamaPinjam + " Hari");
//            }
//        });





        dialogResi = new Dialog(this);
        sheetView = this.getLayoutInflater().inflate(R.layout.popup_masukkan_nomer_resi, null);
        buttonLanjutkanResi = sheetView.findViewById(R.id.button_lanjutkan);
        editTextResi = sheetView.findViewById(R.id.editText_resi);

        dialogResi.setContentView(sheetView);
        dialogResi.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        autoCompleteTextViewKecamatan.setEnabled(false);
        autoCompleteTextViewKota.setEnabled(false);
        alamatLengkap.setEnabled(false);


        buttonStatusTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stateButton == 0){

                    autoCompleteTextViewKecamatan.setEnabled(false);
                    autoCompleteTextViewKota.setEnabled(false);
                    alamatLengkap.setEnabled(false);

                    dialogResi.show();

                    buttonLanjutkanResi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            linearLayoutStatusBuku.setVisibility(View.VISIBLE);
                            textViewResi.setText(editTextResi.getText().toString());
                            buttonStatusTransaksi.setText("Dalam Perjalanan");
                            buttonStatusTransaksi.setEnabled(false);
                            buttonStatusTransaksi.setBackgroundColor(Color.parseColor("#f0f0f0"));
                            buttonStatusTransaksi.setTextColor(Color.parseColor("#000000"));
                            addStatusPengiriman();
                            dialogResi.dismiss();

                            Handler handler2 = new Handler();
                            handler2.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    buttonStatusTransaksi.setEnabled(true);
                                    buttonStatusTransaksi.setBackgroundResource(R.drawable.button_unpressed1);
                                    buttonStatusTransaksi.setTextAppearance(R.style.CustomButton1);
                                    buttonStatusTransaksi.setText("Buku Diterima");


                                }
                            }, 5000);

                            stateButton = 1;


                        }
                    });
                }else if(stateButton == 1){
                    buttonStatusTransaksi.setText("Sedang Dipinjam");
                    buttonStatusTransaksi.setEnabled(false);
                    buttonStatusTransaksi.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    buttonStatusTransaksi.setTextColor(Color.parseColor("#000000"));

                    linearLayoutStatusBuku.setVisibility(View.GONE);


                    Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            buttonStatusTransaksi.setEnabled(true);
                            buttonStatusTransaksi.setBackgroundResource(R.drawable.button_unpressed1);
                            buttonStatusTransaksi.setTextAppearance(R.style.CustomButton1);
                            buttonStatusTransaksi.setText("Kembalikan Buku");


                        }
                    }, 7000);

                    stateButton = 2;

                }else if(stateButton == 2){

                    dialogResi.show();

                    buttonLanjutkanResi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            linearLayoutStatusBuku.setVisibility(View.VISIBLE);
                            textViewResi.setText(editTextResi.getText().toString());
                            buttonStatusTransaksi.setText("Dalam Perjalanan");
                            buttonStatusTransaksi.setEnabled(false);
                            buttonStatusTransaksi.setBackgroundColor(Color.parseColor("#f0f0f0"));
                            buttonStatusTransaksi.setTextColor(Color.parseColor("#000000"));
                            addStatusPengiriman();
                            dialogResi.dismiss();

                            Handler handler2 = new Handler();
                            handler2.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    buttonStatusTransaksi.setEnabled(true);
                                    buttonStatusTransaksi.setBackgroundResource(R.drawable.button_unpressed1);
                                    buttonStatusTransaksi.setTextAppearance(R.style.CustomButton1);
                                    buttonStatusTransaksi.setText("Buku Diterima");


                                }
                            }, 5000);

                            stateButton = 3;


                        }
                    });
                }else if(stateButton == 3 ){
                    buttonStatusTransaksi.setText("Peminjaman Buku Selesai");
                    buttonStatusTransaksi.setEnabled(false);
                    buttonStatusTransaksi.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    buttonStatusTransaksi.setTextColor(Color.parseColor("#000000"));
                    linearLayoutStatusBuku.setVisibility(View.GONE);
                }




            }
        });


        linearLayoutStatusBuku.setVisibility(View.GONE);


        StatusPengirimanAdapter statusPengirimanAdapter = new StatusPengirimanAdapter(ListStatusPengiriman);
        RecyclerView.LayoutManager layoutManagerStatusPengirimanSaya = new LinearLayoutManager(this);
        statusPengiriman.setLayoutManager(layoutManagerStatusPengirimanSaya);
        statusPengiriman.setAdapter(statusPengirimanAdapter);


    }


    private void addStatusPengiriman() {

        ListStatusPengiriman = new ArrayList<>();
        ListStatusPengiriman.add(new StatusPengiriman());
        ListStatusPengiriman.add(new StatusPengiriman());

    }

}
