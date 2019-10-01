package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class TantanganAdapter extends RecyclerView.Adapter<TantanganAdapter.TantanganViewHolder> {


    private ArrayList<Tantangan> ListData;

    public TantanganAdapter(ArrayList<Tantangan> ListData) {
        this.ListData = ListData;
    }

    @Override
    public TantanganViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_tantangan_beranda, parent, false);
        return new TantanganViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TantanganViewHolder holder, int position) {
        holder.TextviewJudul.setText(ListData.get(position).getJudulTantangan());
        holder.TextviewPoin.setText(ListData.get(position).getPoin());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class TantanganViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudul, TextviewPoin;

        public TantanganViewHolder(View itemView) {
            super(itemView);
            TextviewJudul = itemView.findViewById(R.id.textview_judul_buku_akun);

            TextviewPoin = itemView.findViewById(R.id.textview_jaminan_buku);

        }
    }
}
