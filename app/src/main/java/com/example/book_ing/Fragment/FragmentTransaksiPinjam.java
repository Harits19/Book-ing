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
import com.example.book_ing.OtherClass.Transaksi;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentTransaksiPinjam extends Fragment {
    private ArrayList<Transaksi> ListTransaksiPinjam;
    private RecyclerView RecyclerViewTransaksiPinjam;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi_pinjam, container, false);


        addDataTransaksiPinjam();
        RecyclerViewTransaksiPinjam = view.findViewById(R.id.recyclerview_transaksi_pinjam);
        TransaksiAdapter transaksiPinjamAdapter = new TransaksiAdapter(ListTransaksiPinjam, "pinjam");
        RecyclerView.LayoutManager layoutManagerTransaksiPinjam = new LinearLayoutManager(getActivity());
        RecyclerViewTransaksiPinjam.setLayoutManager(layoutManagerTransaksiPinjam);
        RecyclerViewTransaksiPinjam.setAdapter(transaksiPinjamAdapter);

        return view;
    }

    void addDataTransaksiPinjam(){

        ListTransaksiPinjam = new ArrayList<>();
        ListTransaksiPinjam.add(new Transaksi("Bulan", "Asroru Maula", "Tere Liye", getActivity().getDrawable(R.drawable.buku)));
        ListTransaksiPinjam.add(new Transaksi("Microsoft", "Irwan Kurniawan", "John Smith", getActivity().getDrawable(R.drawable.buku1)));
        ListTransaksiPinjam.add(new Transaksi("Revolusi", "Asroru Maula", "Tan Malaka", getActivity().getDrawable(R.drawable.buku2)));





    }
}