package com.example.book_ing.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Activity.ActivityTransaksiPeminjaman2;
import com.example.book_ing.Activity.ActivityTransaksiPenukaran2;
import com.example.book_ing.OtherClass.Transaksi;
import com.example.book_ing.R;

import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.TransaksiPinjamViewHolder> {

    private ViewGroup Parent;
    private String Params;
    private ArrayList<Transaksi> ListData;

    public TransaksiAdapter(ArrayList<Transaksi> ListData, String params) {
        this.ListData = ListData;
        Params = params;
    }

    @Override
    public TransaksiPinjamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Parent = parent;
        View view = layoutInflater.inflate(R.layout.recyclerview_transaksi, parent, false);
        return new TransaksiPinjamViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TransaksiPinjamViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewPengarangBuku.setText(ListData.get(position).getPengarang());
        holder.TextviewStatusPinjam.setText(ListData.get(position).getWaktuPinjam());
        holder.imageViewTransaksi.setImageDrawable(ListData.get(position).getDrawableBukuTransaksi());
        holder.buttonDetailTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Params.equals("pinjam")){
                    Parent.getContext().startActivity(new Intent(Parent.getContext(), ActivityTransaksiPeminjaman2.class));
                }else if(Params.equals("tukar")){
                    Parent.getContext().startActivity(new Intent(Parent.getContext(), ActivityTransaksiPenukaran2.class));
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class TransaksiPinjamViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewPengarangBuku, TextviewStatusPinjam;
        private ImageView imageViewTransaksi;
        private Button buttonDetailTransaksi;

        public TransaksiPinjamViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_judul_buku);
            TextviewPengarangBuku = itemView.findViewById(R.id.textview_pengarang_buku);
            TextviewStatusPinjam = itemView.findViewById(R.id.textview_pemilik);
            imageViewTransaksi = itemView.findViewById(R.id.imageView_transaksi);
            buttonDetailTransaksi = itemView.findViewById(R.id.button_detail_transaksi);
        }
    }
}
