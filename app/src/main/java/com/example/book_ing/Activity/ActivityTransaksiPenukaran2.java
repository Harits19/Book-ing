package com.example.book_ing.Activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.book_ing.R;
import com.example.book_ing.Recyclerview_Kurir.Kurir;
import com.example.book_ing.Recyclerview_Kurir.KurirAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityTransaksiPenukaran2 extends AppCompatActivity {

    Button buttonPilihBuku;
    Dialog myDialog;
    RecyclerView recyclerViewPilihBukuPenukarn;
    View sheetView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_penukaran2);
        myDialog = new Dialog(this);


//        DataAdapter dataAdapter = new DataAdapter(items, this);
//        customDialog = new CustomListViewDialog(HomeActivity.this, dataAdapter);
//
//        customDialog.show();
//        customDialog.setCanceledOnTouchOutside(false);

        buttonPilihBuku = findViewById(R.id.button_pilih_buku);
            sheetView = this.getLayoutInflater().inflate(R.layout.popup_pilih_kurir, null);

                buttonPilihBuku.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {
                myDialog.setContentView(sheetView);
                myDialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                myDialog.show();
            }
        });



    }

}
