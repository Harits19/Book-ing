package com.example.book_ing.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.book_ing.Activity.ActivityKatalogPeminjaman;
import com.example.book_ing.Activity.ActivityKatalogPenukaran;

import com.example.book_ing.Activity.ActivityTambahSaldo;
import com.example.book_ing.Activity.ActivityTantangan;
import com.example.book_ing.Adapter.BeritaAdapter;
import com.example.book_ing.Adapter.TantanganAdapter;
import com.example.book_ing.OtherClass.Berita;
import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class FragmentBeranda extends Fragment {

    private Button  ButtonTambahSaldo;
    private ImageView ButtonPinjam, ButtonTukar;
    private RecyclerView RecyclerviewTantangan, RecyclerviewBerita;
    private TextView textViewLihatSemuaTantangan;
    private ArrayList<Tantangan> ListTantangan;
    private ArrayList<Berita> ListBerita;

    private BottomSheetBehavior mBottomSheetBehavior;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);





        ButtonPinjam = view.findViewById(R.id.button_pinjam_buku);
        textViewLihatSemuaTantangan = view.findViewById(R.id.textview_lihat_tantangan);
        ButtonTambahSaldo = view.findViewById(R.id.button_tambah_saldo);
        ButtonTukar = view.findViewById(R.id.button_tukar_buku);
        RecyclerviewTantangan = view.findViewById(R.id.recyclerview_koleksi_buku_akun);
        RecyclerviewBerita = view.findViewById(R.id.recyclerview_berita);

        textViewLihatSemuaTantangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity() , ActivityTantangan.class));
            }
        });

        ButtonPinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity() , ActivityKatalogPeminjaman.class);
//                intent.putExtra("params", "tukar");
                startActivity(intent);

            }
        });

        ButtonTambahSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , ActivityTambahSaldo.class));

            }
        });

        ButtonTukar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity() , ActivityKatalogPenukaran.class);
//                intent.putExtra("params", "tukar");
                startActivity(intent);
            }
        });

        addListTantangan();

        //RecyclerviewTantangan
        TantanganAdapter myAdapter = new TantanganAdapter(ListTantangan);
        RecyclerviewTantangan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerviewTantangan.setAdapter(myAdapter);

        addDataBerita();
        RecyclerviewBerita = view.findViewById(R.id.recyclerview_berita);
        BeritaAdapter beritaAdapter = new BeritaAdapter(ListBerita);
        RecyclerView.LayoutManager layoutManagerBerita = new LinearLayoutManager(getActivity());
        RecyclerviewBerita.setLayoutManager(layoutManagerBerita);
        RecyclerviewBerita.setAdapter(beritaAdapter);
        RecyclerviewBerita.setNestedScrollingEnabled(false);




        return view;
    }

    private void addListTantangan() {
        ListTantangan = new ArrayList<>();
        ListTantangan.add(new Tantangan("Membaca Buku Kiat Sukses Kewirausahaan", "1000", getActivity().getDrawable(R.drawable.cover_kwu)));
        ListTantangan.add(new Tantangan("Membaca Buku Revolusi Belum Selesai", "2000", getActivity().getDrawable(R.drawable.buku)));
        ListTantangan.add(new Tantangan("Buku Pintar Microsoft Office", "1500", getActivity().getDrawable(R.drawable.buku2)));

    }

    private void addDataBerita() {
        ListBerita = new ArrayList<>();
        ListBerita.add(new Berita("Gramedia 'Buka Gudang' Jual Buku Murah, Diskon hingga 50%, Buku Komik Cuma Rp 1.000", "Toko Buku Gramedia menjual buku-buku berbagai macam dengan harga diskon gede-gedean. Diskon buku dengan tema 'Buka Gudang' Gramedia itu digelar di kompleks Kompas Gramedia, Palmerah Selatan, Jakarta. Diskon gede-gedean diadakan sejak 1 Oktober hingga 31 Oktober 2019", getActivity().getDrawable(R.drawable.berita)));
        ListBerita.add(new Berita("Gramedia 'Buka Gudang' Jual Buku Murah, Diskon hingga 50%, Buku Komik Cuma Rp 1.000", "Toko Buku Gramedia menjual buku-buku berbagai macam dengan harga diskon gede-gedean. Diskon buku dengan tema 'Buka Gudang' Gramedia itu digelar di kompleks Kompas Gramedia, Palmerah Selatan, Jakarta. Diskon gede-gedean diadakan sejak 1 Oktober hingga 31 Oktober 2019", getActivity().getDrawable(R.drawable.berita1)));
        ListBerita.add(new Berita("Gramedia 'Buka Gudang' Jual Buku Murah, Diskon hingga 50%, Buku Komik Cuma Rp 1.000", "Toko Buku Gramedia menjual buku-buku berbagai macam dengan harga diskon gede-gedean. Diskon buku dengan tema 'Buka Gudang' Gramedia itu digelar di kompleks Kompas Gramedia, Palmerah Selatan, Jakarta. Diskon gede-gedean diadakan sejak 1 Oktober hingga 31 Oktober 2019", getActivity().getDrawable(R.drawable.berita2)));
//
    }
}
