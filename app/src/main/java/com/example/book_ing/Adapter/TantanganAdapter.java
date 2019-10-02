package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Tantangan;
import com.example.book_ing.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.ParseException;
import java.util.ArrayList;

public class TantanganAdapter extends RecyclerView.Adapter<TantanganAdapter.TantanganViewHolder> {


    private ArrayList<Tantangan> ListData;

    public TantanganAdapter(ArrayList<Tantangan> ListData) {
        this.ListData = ListData;
    }

    ViewGroup Parent;

    @Override
    public TantanganViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_tantangan, parent, false);
        Parent = parent;
        return new TantanganViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final TantanganViewHolder holder, int position) {
        holder.TextviewJudul.setText(ListData.get(position).getJudulTantangan());
        holder.TextviewPoin.setText(ListData.get(position).getPoin());
        holder.cardViewTantangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View modelBottomSheet = LayoutInflater.from(Parent.getContext()).inflate(R.layout.bottomsheet_detail_tantangan, null);
                BottomSheetDialog dialog = new BottomSheetDialog(Parent.getContext());
                dialog.setContentView(modelBottomSheet);
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class TantanganViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudul, TextviewPoin;
        private CardView cardViewTantangan;


        public TantanganViewHolder(View itemView) {
            super(itemView);
            TextviewJudul = itemView.findViewById(R.id.textview_judul_buku);
            TextviewPoin = itemView.findViewById(R.id.textview_jaminan_buku);
            cardViewTantangan = itemView.findViewById(R.id.cardview_tantangan);


        }
    }
}
