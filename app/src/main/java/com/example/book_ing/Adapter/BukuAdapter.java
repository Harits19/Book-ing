package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.util.ArrayList;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {


    private ArrayList<Buku> ListData;

    public BukuAdapter(ArrayList<Buku> ListData) {
        this.ListData = ListData;
    }

    @Override
    public BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_koleksi_buku_akun, parent, false);
        return new BukuViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BukuViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewJaminanBuku.setText(ListData.get(position).getJaminanBuku());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewJaminanBuku;

        public BukuViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_jaminan_buku_akun);
            TextviewJaminanBuku = itemView.findViewById(R.id.textview_jaminan_buku_akun);

        }
    }
}
