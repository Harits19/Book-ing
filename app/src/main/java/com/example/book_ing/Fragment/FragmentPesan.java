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

import com.example.book_ing.Adapter.PesanAdapter;
import com.example.book_ing.OtherClass.Pesan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentPesan extends Fragment {
    
    private RecyclerView RecyclerviewPesan;
    private ArrayList<Pesan> ListPesan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesan, container, false);

        RecyclerviewPesan = view.findViewById(R.id.recyclerview_pesan);
        addListPesan();
        PesanAdapter myAdapter = new PesanAdapter(ListPesan);
        RecyclerView.LayoutManager layoutManagerBerita = new LinearLayoutManager(getActivity());
        RecyclerviewPesan.setLayoutManager(layoutManagerBerita);
        RecyclerviewPesan.setAdapter(myAdapter);
        
        return view;
    }

    private void addListPesan() {

        ListPesan = new ArrayList<>();
        ListPesan.add(new Pesan("Abdullah Harits", "Saya ingin meminjam buku ini", "20 Oktober 2019", null));
        ListPesan.add(new Pesan("Abdullah Harits", "Saya ingin meminjam buku ini", "20 Oktober 2019", null));
        ListPesan.add(new Pesan("Abdullah Harits", "Saya ingin meminjam buku ini", "20 Oktober 2019", null));
        ListPesan.add(new Pesan("Abdullah Harits", "Saya ingin meminjam buku ini", "20 Oktober 2019", null));
        ListPesan.add(new Pesan("Abdullah Harits", "Saya ingin meminjam buku ini", "20 Oktober 2019", null));

    }
}
