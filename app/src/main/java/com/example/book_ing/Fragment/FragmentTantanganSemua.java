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
import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class FragmentTantanganSemua extends Fragment {
    private ArrayList<Tantangan> ListTantangan;
    private RecyclerView RecyclerViewTantangan;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tantangan_semua, container, false);


        addDataTantanganPinjam();
        RecyclerViewTantangan = view.findViewById(R.id.recyclerview_tantangan_semua);
        TantanganAdapter TantanganPinjamAdapter = new TantanganAdapter(ListTantangan);
        RecyclerViewTantangan.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RecyclerViewTantangan.setAdapter(TantanganPinjamAdapter);

        return view;
    }

    void addDataTantanganPinjam(){

        ListTantangan = new ArrayList<>();
        ListTantangan.add(new Tantangan("Revolusi", "2 Oktober 2019", getActivity().getDrawable(R.drawable.cover_kwu) ));
        ListTantangan.add(new Tantangan("Killing Henninway", "2 Oktober 2019", getActivity().getDrawable(R.drawable.buku)));
        ListTantangan.add(new Tantangan("Killing Henninway", "2 Oktober 2019", getActivity().getDrawable(R.drawable.buku2)));
        ListTantangan.add(new Tantangan("Killing Henninway", "2 Oktober 2019", getActivity().getDrawable(R.drawable.buku1)));
        ListTantangan.add(new Tantangan("Killing Henninway", "2 Oktober 2019", getActivity().getDrawable(R.drawable.buku)));




    }
}