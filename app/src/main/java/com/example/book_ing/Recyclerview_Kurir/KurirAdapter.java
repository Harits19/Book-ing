package com.example.book_ing.Recyclerview_Kurir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
//import com.demotxt.myapp.myapplication.R;
//import com.demotxt.myapp.myapplication.model.Anime;

import com.example.book_ing.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class KurirAdapter extends RecyclerView.Adapter<KurirAdapter.MyViewHolder> {

//    RequestOptions options;
    private Context mContext;
    private ArrayList<Kurir> mData;


    public KurirAdapter(Context mContext, ArrayList ListKurir) {


        this.mContext = mContext;
        this.mData = ListKurir;
//        options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.drawable.loading)
//                .error(R.drawable.loading);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


//
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.recyclerview_kurir, parent, false);
//        return new MyViewHolder(view);
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.recyclerview_kurir,parent,false);
        // click listener here
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.Service.setText(mData.get(position).getService());
        holder.Harga.setText(mData.get(position).getHarga());
        holder.Estimasi.setText(mData.get(position).getEstimasi());




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Service, Harga, Estimasi, tvcat;


        public MyViewHolder(View itemView) {
            super(itemView);
            Service = itemView.findViewById(R.id.textview_service);
            Harga = itemView.findViewById(R.id.textview_harga);
            Estimasi = itemView.findViewById(R.id.textview_estimasi);

        }
    }


}