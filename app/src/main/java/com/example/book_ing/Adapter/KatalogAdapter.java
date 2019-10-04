package com.example.book_ing.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Activity.ActivityDetailBukuPeminjaman;
import com.example.book_ing.Activity.ActivityDetailBukuPenukaran;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.util.ArrayList;

public class KatalogAdapter extends RecyclerView.Adapter<KatalogAdapter.KatalogViewHolder> {


    ViewGroup Parent;
    private ArrayList<Buku> ListData;
    private String Params;

    public KatalogAdapter(ArrayList<Buku> ListData, String params) {
        this.ListData = ListData;
        Params = params;
    }

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
                if (Params.equals("penukaran"))
                    Parent.getContext().startActivity(new Intent(Parent.getContext(), ActivityDetailBukuPenukaran.class));
                else if (Params.equals("peminjaman"))
                    Parent.getContext().startActivity(new Intent(Parent.getContext(), ActivityDetailBukuPeminjaman.class));


            }
        });


    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class KatalogViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayoutKatalog;
        private TextView TextviewJudulKatalog, TextviewLokasiKatalog, TextviewJaminanKatalog, TextviewTerpinjamKatalog, TextviewPemilikKatalog;

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
