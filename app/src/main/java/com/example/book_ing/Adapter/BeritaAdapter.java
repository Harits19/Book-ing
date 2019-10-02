package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Berita;
import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {


    private ArrayList<Berita> ListData;

    public BeritaAdapter(ArrayList<Berita> ListData) {
        this.ListData = ListData;
    }

    @Override
    public BeritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_berita, parent, false);
        return new BeritaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BeritaViewHolder holder, int position) {
        holder.TextviewJudulBerita.setText(ListData.get(position).getJudulBerita());
        holder.TextviewRingkasanBerita.setText(ListData.get(position).getRingkasanBerita());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class BeritaViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBerita, TextviewRingkasanBerita;

        public BeritaViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBerita = itemView.findViewById(R.id.textview_judul_berita);
            TextviewRingkasanBerita = itemView.findViewById(R.id.textview_ringkasan_berita);

        }
    }
}
