package com.example.book_ing.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Activity.ActivityDetailBuku;
import com.example.book_ing.Activity.ActivityDetailPesan;
import com.example.book_ing.OtherClass.Transaksi;
import com.example.book_ing.R;

import java.util.ArrayList;

public class TukarNotifikasiAdapter extends RecyclerView.Adapter<TukarNotifikasiAdapter.TransaksiPinjamViewHolder> {


    private ArrayList<Transaksi> ListData;

    public TukarNotifikasiAdapter(ArrayList<Transaksi> ListData) {
        this.ListData = ListData;
    }

    ViewGroup Parent;

    @Override
    public TransaksiPinjamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Parent = parent;
        View view = layoutInflater.inflate(R.layout.recyclerview_penukaran_notifikasi, parent, false);
        return new TransaksiPinjamViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TransaksiPinjamViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewPengarangBuku.setText(ListData.get(position).getPengarang());
        holder.TextviewWaktuPinjam.setText(ListData.get(position).getWaktuPinjam());
        holder.buttonTerima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parent.getContext().startActivity(new Intent(Parent.getContext(), ActivityDetailBuku.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class TransaksiPinjamViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewPengarangBuku, TextviewWaktuPinjam;
        private Button buttonTerima;

        public TransaksiPinjamViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_judul_buku);
            TextviewPengarangBuku = itemView.findViewById(R.id.textview_pengarang_buku);
            TextviewWaktuPinjam = itemView.findViewById(R.id.textview_Isbn_buku);
            buttonTerima = itemView.findViewById(R.id.button_terima);

        }
    }
}
