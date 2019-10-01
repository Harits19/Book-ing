package com.example.book_ing.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.Activity.ActivityDetailPesan;
import com.example.book_ing.OtherClass.Pesan;
import com.example.book_ing.R;

import java.util.ArrayList;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.PesanViewHolder> {


    private ArrayList<Pesan> ListData;
    private ViewGroup Parent;

    public PesanAdapter(ArrayList<Pesan> ListData) {
        this.ListData = ListData;
    }

    @Override
    public PesanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_pesan, parent, false);
        this.Parent = parent;
        return new PesanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PesanViewHolder holder, int position) {
        holder.TextviewPengirimPesan.setText(ListData.get(position).getPengirimPesan());
        holder.TextviewRingkasanPesan.setText(ListData.get(position).getRingkasanPesan());
        holder.TextviewWaktuPesan.setText(ListData.get(position).getWaktuPesan());

        holder.TextviewRingkasanPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parent.getContext().startActivity(new Intent(Parent.getContext(), ActivityDetailPesan.class));

            }
        });
//        holder.ImageViewPengirimPesan.setImageBitmap(ListData.get(position).getProfilPengirimPesan());

    }

    @Override
    public int getItemCount() {
        return (ListData != null) ? ListData.size() : 0;
    }

    public class PesanViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewPengirimPesan, TextviewRingkasanPesan, TextviewWaktuPesan;
        private ImageView ImageViewPengirimPesan;
        private ConstraintLayout ConstraintlayoutPesan;

        public PesanViewHolder(View itemView) {
            super(itemView);
            TextviewPengirimPesan = itemView.findViewById(R.id.textview_pengirim_pesan);
            TextviewRingkasanPesan = itemView.findViewById(R.id.textview_ringkasan_pesan);
            TextviewWaktuPesan = itemView.findViewById(R.id.textview_waktu_pesan);
            ImageViewPengirimPesan = itemView.findViewById(R.id.imageview_pengirim_pesan);
            ConstraintlayoutPesan = itemView.findViewById(R.id.constraintlayout_pesan);


        }
    }
}
