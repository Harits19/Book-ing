package com.example.book_ing.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Activity.ActivityDetailBuku;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.text.ParseException;
import java.util.ArrayList;

public class KatalogAdapter extends RecyclerView.Adapter<KatalogAdapter.KatalogViewHolder> {


    private ArrayList<Buku> ListData;

    public KatalogAdapter(ArrayList<Buku> ListData) {
        this.ListData = ListData;
    }

    ViewGroup Parent;

    @Override
    public KatalogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_katalog, parent, false);
        this.Parent = parent;
        return new KatalogViewHolder(view);

    }

    @Override
    public void onBindViewHolder(KatalogViewHolder holder, int position) {
        holder.TextviewJudulKatalog.setText(ListData.get(position).getJudulBuku());
        holder.TextviewJaminanKatalog.setText(ListData.get(position).getJaminanBuku());
        holder.TextviewTerpinjamKatalog.setText(ListData.get(position).getTerpinjam());
        holder.TextviewPemilikKatalog.setText(ListData.get(position).getPemilik());
        holder.TextviewLokasiKatalog.setText(ListData.get(position).getLokasi());
        holder.constraintLayoutKatalog.setOnClickListener(new View.OnClickListener() {
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

    public class KatalogViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulKatalog , TextviewLokasiKatalog , TextviewJaminanKatalog, TextviewTerpinjamKatalog , TextviewPemilikKatalog;
        ConstraintLayout constraintLayoutKatalog;

        public KatalogViewHolder(View itemView) {
            super(itemView);

            TextviewJudulKatalog = itemView.findViewById(R.id.textview_judul_buku_katalog);
            TextviewJaminanKatalog = itemView.findViewById(R.id.textview_jaminan_katalog);
            TextviewTerpinjamKatalog = itemView.findViewById(R.id.textview_terpinjam_katalog);
            TextviewPemilikKatalog = itemView.findViewById(R.id.textview_pemilik_katalog);
            TextviewLokasiKatalog = itemView.findViewById(R.id.textview_lokasi_katalog);
            constraintLayoutKatalog = itemView.findViewById(R.id.constraintlayout_recyclerview_katalog);



        }
    }
}
