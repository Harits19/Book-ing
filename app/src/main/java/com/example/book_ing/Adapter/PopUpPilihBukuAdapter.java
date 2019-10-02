package com.example.book_ing.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Activity.ActivityDetailBuku;
import com.example.book_ing.Activity.ActivityTransaksiPenukaran;
import com.example.book_ing.Activity.ActivityTransaksiPenukaran2;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;

import java.util.ArrayList;

public class PopUpPilihBukuAdapter extends RecyclerView.Adapter<PopUpPilihBukuAdapter.BukuViewHolder> {


    private ArrayList<Buku> ListData;
    private ViewGroup Parent;

    public PopUpPilihBukuAdapter(ArrayList<Buku> ListData) {
        this.ListData = ListData;
    }

    @Override
    public BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Parent = parent;
        View view = layoutInflater.inflate(R.layout.recyclerview_popup_buku_transaksi_penukaran, parent, false);


        return new BukuViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BukuViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewIsbnBuku.setText(ListData.get(position).getIsbn());
        holder.textViewPengarangBuku.setText(ListData.get(position).getJudulBuku());
        holder.buttonPilihBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityTransaksiPenukaran2.buttonPilihBuku.setVisibility(View.GONE);
                ActivityTransaksiPenukaran2.constraintLayoutBukuDipilih.setVisibility(View.VISIBLE);

            }
        });

        holder.buttonDetailBuku.setOnClickListener(new View.OnClickListener() {
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

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewIsbnBuku, textViewPengarangBuku;
        private Button buttonPilihBuku, buttonDetailBuku;

        private RecyclerView recyclerViewPilihBuku;


        public BukuViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_judul_buku);
            TextviewIsbnBuku = itemView.findViewById(R.id.textview_Isbn_buku);
            textViewPengarangBuku = itemView.findViewById(R.id.textview_pengarang_buku);

            buttonPilihBuku = itemView.findViewById(R.id.button_pilih_buku);
            buttonDetailBuku = itemView.findViewById(R.id.button_detail_buku);
            recyclerViewPilihBuku = itemView.findViewById(R.id.recyclerView_pilih_buku);




        }
    }
}
