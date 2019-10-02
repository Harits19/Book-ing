package com.example.book_ing.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {


    private ArrayList<Buku> ListData;

    public BukuAdapter(ArrayList<Buku> ListData) {
        this.ListData = ListData;
    }

    private ViewGroup Parent;
    @Override
    public BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Parent = parent;
        View view = layoutInflater.inflate(R.layout.recyclerview_koleksi_buku_akun, parent, false);
        return new BukuViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BukuViewHolder holder, int position) {
        holder.TextviewJudulBuku.setText(ListData.get(position).getJudulBuku());
        holder.TextviewJaminanBuku.setText(ListData.get(position).getJaminanBuku());
        holder.linearLayoutBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View modelBottomSheet = LayoutInflater.from(Parent.getContext()).inflate(R.layout.bottomsheet_koleksi_buku, null);
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

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        private TextView TextviewJudulBuku, TextviewJaminanBuku;
        private LinearLayout linearLayoutBuku;

        public BukuViewHolder(View itemView) {
            super(itemView);
            TextviewJudulBuku = itemView.findViewById(R.id.textview_jaminan_buku_akun);
            TextviewJaminanBuku = itemView.findViewById(R.id.textview_jaminan_buku_akun);
            linearLayoutBuku = itemView.findViewById(R.id.linearLayoutBuku);

        }
    }
}
