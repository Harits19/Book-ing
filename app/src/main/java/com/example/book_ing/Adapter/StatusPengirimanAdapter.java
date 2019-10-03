package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.StatusPengiriman;
import com.example.book_ing.R;

import java.util.ArrayList;

public class StatusPengirimanAdapter extends RecyclerView.Adapter<StatusPengirimanAdapter.StatusPengirimanViewHolder> {


    private ArrayList<StatusPengiriman> ListData;

    public StatusPengirimanAdapter(ArrayList<StatusPengiriman> ListData) {
        this.ListData = ListData;
    }

    @Override
    public StatusPengirimanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_status_pengiriman, parent, false);
        return new StatusPengirimanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(StatusPengirimanViewHolder holder, int position) {
//        holder.TextviewJudulStatusPengiriman.setText(ListData.get(position).getJudulStatusPengiriman());
//        holder.TextviewRingkasanStatusPengiriman.setText(ListData.get(position).getRingkasanStatusPengiriman());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class StatusPengirimanViewHolder extends RecyclerView.ViewHolder {
//        private TextView TextviewJudulStatusPengiriman, TextviewRingkasanStatusPengiriman;

        public StatusPengirimanViewHolder(View itemView) {
            super(itemView);
//            TextviewJudulStatusPengiriman = itemView.findViewById(R.id.textview_judul_StatusPengiriman);
//            TextviewRingkasanStatusPengiriman = itemView.findViewById(R.id.textview_ringkasan_StatusPengiriman);

        }
    }
}
