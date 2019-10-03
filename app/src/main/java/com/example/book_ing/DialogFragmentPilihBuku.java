package com.example.book_ing;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Adapter.PopUpPilihBukuAdapter;

import java.util.ArrayList;

public class DialogFragmentPilihBuku extends DialogFragment {

    private ArrayList listBuku;
    private RecyclerView recyclerViewPilihBuku;
    private PopUpPilihBukuAdapter popUpPilihBukuAdapter;

    public DialogFragmentPilihBuku(ArrayList listBuku) {
        this.listBuku = listBuku;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.popup_pilih_buku_transaksi_penukaran, container);
        recyclerViewPilihBuku = view.findViewById(R.id.recyclerView_pilih_buku);
        recyclerViewPilihBuku.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        popUpPilihBukuAdapter = new PopUpPilihBukuAdapter(listBuku);
        recyclerViewPilihBuku.setAdapter(popUpPilihBukuAdapter);


        return view;
    }
}
