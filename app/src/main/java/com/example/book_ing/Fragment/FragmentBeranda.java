package com.example.book_ing.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.book_ing.Activity.ActivityKatalog;
import com.example.book_ing.Adapter.BeritaAdapter;
import com.example.book_ing.Adapter.TantanganAdapter;
import com.example.book_ing.OtherClass.Berita;
import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentBeranda extends Fragment {

    private Button ButtonPinjam, ButtonTukar;
    private RecyclerView RecyclerviewTantangan, RecyclerviewBerita;
    private ArrayList<Tantangan> ListTantangan;
    private ArrayList<Berita> ListBerita;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        ButtonPinjam = view.findViewById(R.id.button_pinjam_buku);
        ButtonTukar = view.findViewById(R.id.button_tukar_buku);
        RecyclerviewTantangan = view.findViewById(R.id.recyclerview_koleksi_buku_akun);
        RecyclerviewBerita = view.findViewById(R.id.recyclerview_berita);

        ButtonPinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , ActivityKatalog.class));

            }
        });

        ButtonTukar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , ActivityKatalog.class));

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
        ListTantangan.add(new Tantangan("AA", "2999"));
        ListTantangan.add(new Tantangan("AA", "2999"));
        ListTantangan.add(new Tantangan("AA", "2999"));
        ListTantangan.add(new Tantangan("AA", "2999"));

    }

    private void addDataBerita() {
        ListBerita = new ArrayList<>();
        ListBerita.add(new Berita("AA", "AA"));
        ListBerita.add(new Berita("BB", "AA"));
        ListBerita.add(new Berita("CC", "CC"));
        ListBerita.add(new Berita("DD", "DD"));
//
    }
}
