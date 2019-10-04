package com.example.book_ing.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Adapter.TransaksiAdapter;
import com.example.book_ing.Adapter.TukarNotifikasiAdapter;
import com.example.book_ing.OtherClass.Transaksi;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentTransaksiTukar extends Fragment {
    private ArrayList<Transaksi> ListTransaksiTukar;
    private ArrayList<Transaksi> ListTukarNotifikasi;
    private RecyclerView RecyclerViewTransaksiTukar;
    private RecyclerView RecyclerViewTukarNotifikasi;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi_tukar, container, false);

        addDataTransaksiTukar();
        RecyclerViewTransaksiTukar = view.findViewById(R.id.recyclerview_transaksi_tukar);
        TransaksiAdapter TransaksiTukarAdapter = new TransaksiAdapter(ListTransaksiTukar, "tukar");
        RecyclerView.LayoutManager layoutManagerTransaksiTukar = new LinearLayoutManager(getActivity());
        RecyclerViewTransaksiTukar.setLayoutManager(layoutManagerTransaksiTukar);
        RecyclerViewTransaksiTukar.setAdapter(TransaksiTukarAdapter);

        //Smoooth Scrolling
        RecyclerViewTransaksiTukar.setNestedScrollingEnabled(false);


        addListTukarNotifikasi();
        RecyclerViewTukarNotifikasi = view.findViewById(R.id.recyclerview_penukaran_notifikasi);
        TukarNotifikasiAdapter tukarNotifikasiAdapter = new TukarNotifikasiAdapter(ListTukarNotifikasi);
        RecyclerView.LayoutManager layoutManagerTukarNotifikasi = new LinearLayoutManager(getActivity());
        RecyclerViewTukarNotifikasi.setLayoutManager(layoutManagerTukarNotifikasi);
        RecyclerViewTukarNotifikasi.setAdapter(tukarNotifikasiAdapter);
        RecyclerViewTukarNotifikasi.setNestedScrollingEnabled(false);


        return view;
    }

    void addDataTransaksiTukar(){

        ListTransaksiTukar = new ArrayList<>();
        ListTransaksiTukar.add(new Transaksi("revolusi", "Asroru Maula", "Tere Liye", getActivity().getDrawable(R.drawable.buku2)));
        ListTransaksiTukar.add(new Transaksi("Microsoft", "Irwan Kurniawan", "John Smith", getActivity().getDrawable(R.drawable.buku1)));




    }

    void addListTukarNotifikasi(){

        ListTukarNotifikasi = new ArrayList<>();
        ListTukarNotifikasi.add(new Transaksi("Bulan", "Asroru Maula", "Tere Liye", getActivity().getDrawable(R.drawable.buku)));








    }
}