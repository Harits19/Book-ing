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
import android.widget.TextView;

import com.example.book_ing.Activity.ActivityTambahKoleksiBuku;
import com.example.book_ing.Adapter.BukuAdapter;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentAkun extends Fragment {

        private ArrayList<Buku> ListBukuKoleksi;
        private TextView ButtonTambahKoleksi;
        private RecyclerView RecyclerviewKoleksiBuku;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_akun, container, false);

        RecyclerviewKoleksiBuku = view.findViewById(R.id.recyclerview_koleksi_buku_akun);
        ButtonTambahKoleksi = view.findViewById(R.id.button_tambah_koleksi);

        ButtonTambahKoleksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , ActivityTambahKoleksiBuku.class));

            }
        });



        addListBukuKoleksi();
        BukuAdapter myAdapter = new BukuAdapter(ListBukuKoleksi);
        RecyclerviewKoleksiBuku.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerviewKoleksiBuku.setAdapter(myAdapter);
        return view;
    }

    private void addListBukuKoleksi() {

         ListBukuKoleksi = new ArrayList<>();
        ListBukuKoleksi.add(new Buku("AA", "Rp 20.000"));
        ListBukuKoleksi.add(new Buku("BB", "Rp 20.000"));
        ListBukuKoleksi.add(new Buku("CC", "Rp 20.000"));
        ListBukuKoleksi.add(new Buku("DD", "Rp 20.000"));
    }

}
