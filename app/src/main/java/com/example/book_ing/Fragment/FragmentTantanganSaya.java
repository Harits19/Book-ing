package com.example.book_ing.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Adapter.TantanganAdapter;
import com.example.book_ing.Adapter.TantanganAdapter;
import com.example.book_ing.Adapter.TantanganSayaAdapter;
import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentTantanganSaya extends Fragment {
    private ArrayList<Tantangan> ListTantanganSaya;
    private RecyclerView RecyclerViewTantanganSaya;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tantangan_saya, container, false);


        addDataTantanganPinjam();
        RecyclerViewTantanganSaya = view.findViewById(R.id.recyclerView_tantangan_saya);
        TantanganSayaAdapter tantanganSayaAdapter = new TantanganSayaAdapter(ListTantanganSaya);
        RecyclerView.LayoutManager layoutManagerTantanganPinjam = new LinearLayoutManager(getActivity());
        RecyclerViewTantanganSaya.setLayoutManager(layoutManagerTantanganPinjam);
        RecyclerViewTantanganSaya.setAdapter(tantanganSayaAdapter);

        return view;
    }

    void addDataTantanganPinjam(){

        ListTantanganSaya = new ArrayList<>();
        ListTantanganSaya.add(new Tantangan("Killing Henninway", "2 Oktober 2019"));
        ListTantanganSaya.add(new Tantangan("Killing Henninway", "2 Oktober 2019"));
        ListTantanganSaya.add(new Tantangan("Killing Henninway", "2 Oktober 2019"));
        ListTantanganSaya.add(new Tantangan("Killing Henninway", "2 Oktober 2019"));
        ListTantanganSaya.add(new Tantangan("Killing Henninway", "2 Oktober 2019"));




    }
}