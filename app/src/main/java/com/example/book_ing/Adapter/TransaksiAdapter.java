package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Transaksi;
import com.example.book_ing.R;

import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.TransaksiPinjamViewHolder> {


    private ArrayList<Transaksi> ListData;

    public TransaksiAdapter(ArrayList<Transaksi> ListData) {
        this.ListData = ListData;
    }

    @Override
    public TransaksiPinjamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_transaksi, parent, false);
        return new TransaksiPinjamViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TransaksiPinjamViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewPengarangBuku.setText(ListData.get(position).getPengarang());
        holder.TextviewStatusPinjam.setText(ListData.get(position).getWaktuPinjam());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class TransaksiPinjamViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewPengarangBuku, TextviewStatusPinjam;

        public TransaksiPinjamViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_judul_buku);
            TextviewPengarangBuku = itemView.findViewById(R.id.textview_pengarang_buku);
            TextviewStatusPinjam = itemView.findViewById(R.id.textview_Isbn_buku);

        }
    }
}
