package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Transaksi;
import com.example.book_ing.R;

import java.util.ArrayList;

public class TukarNotifikasiAdapter extends RecyclerView.Adapter<TukarNotifikasiAdapter.TransaksiPinjamViewHolder> {


    private ArrayList<Transaksi> ListData;

    public TukarNotifikasiAdapter(ArrayList<Transaksi> ListData) {
        this.ListData = ListData;
    }

    @Override
    public TransaksiPinjamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_penukaran_notifikasi, parent, false);
        return new TransaksiPinjamViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TransaksiPinjamViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewPengarangBuku.setText(ListData.get(position).getPengarang());
        holder.TextviewWaktuPinjam.setText(ListData.get(position).getWaktuPinjam());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class TransaksiPinjamViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewPengarangBuku, TextviewWaktuPinjam;

        public TransaksiPinjamViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_judul_buku_pinjam);
            TextviewPengarangBuku = itemView.findViewById(R.id.textview_pengarang_buku_pinjam);
            TextviewWaktuPinjam = itemView.findViewById(R.id.textview_waktu_buku_pinjam);

        }
    }
}
