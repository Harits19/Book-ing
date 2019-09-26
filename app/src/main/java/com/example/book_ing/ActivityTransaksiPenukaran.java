package com.example.book_ing;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityTransaksiPenukaran extends AppCompatActivity {


    ArrayList<String> ListKota = new ArrayList<String>();
    ArrayList<String> ListNamaKecamatanAsal = new ArrayList<String>();
    ArrayList<String> ListIdKecamatanAsal = new ArrayList<String>();
    ArrayList<String> ListNamaKecamatanTujuan = new ArrayList<String>();
    ArrayList<String> ListIdKecamatanTujuan = new ArrayList<String>();
    ArrayList<String> ListService = new ArrayList<String>();
    TextView ongkir;
    ProgressBar progressBar;
    private String idKecamatanAsal, idKotaAsal, idKecamatanTujuan, idKotaTujuan;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_penukaran);

        ongkir = findViewById(R.id.ongkir);

        progressBar = findViewById(R.id.progressBar1);
        progressBar.setMax(10);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);


        mQueue = Volley.newRequestQueue(this);
        new JSONParse("http://api.shipping.esoftplay.com/city", "kota").execute();

        //AUTO COMPLETE TEXT UNTUK KOTA
        ArrayAdapter<String> adapterKota = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ListKota);

        final AutoCompleteTextView KotaAsal = findViewById(R.id.kota_asal);
        final AutoCompleteTextView KotaTujuan = findViewById(R.id.kota_tujuan);

        KotaAsal.setAdapter(adapterKota);
        KotaTujuan.setAdapter(adapterKota);


        //AUTO COMPLETE TEXT UNTUK KECAMATAN
        ArrayAdapter<String> adapterKecamatanAsal = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ListNamaKecamatanAsal);

        ArrayAdapter<String> adapterKecamatanTujuan = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ListNamaKecamatanTujuan);

        final AutoCompleteTextView KecamatanAsal = findViewById(R.id.kecamatan_asal);
        final AutoCompleteTextView KecamatanTujuan = findViewById(R.id.kecamatan_tujuan);

        KecamatanAsal.setAdapter(adapterKecamatanAsal);
        KecamatanTujuan.setAdapter(adapterKecamatanTujuan);


        //MENDAPAT ID KOTA
        KotaAsal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {

                idKotaAsal = String.valueOf(ListKota.indexOf(KotaAsal.getText().toString()) + 1);
                new JSONParse("http://api.shipping.esoftplay.com/subdistrict/" + idKotaAsal, "kecamatanAsal").execute();
                Log.d("url1", idKotaAsal);


            }
        });

        KotaTujuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {

                idKotaTujuan = String.valueOf(ListKota.indexOf(KotaTujuan.getText().toString()) + 1);
                new JSONParse("http://api.shipping.esoftplay.com/subdistrict/" + idKotaTujuan, "kecamatanTujuan").execute();
                Log.d("url2", idKotaTujuan);


            }
        });


        //MENDAPAT ID KECAMATAN
        KecamatanAsal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {

                int indeksSubdistrict = ListNamaKecamatanAsal.indexOf(KecamatanAsal.getText().toString());


                idKecamatanAsal = String.valueOf(ListIdKecamatanAsal.get(indeksSubdistrict));
                Log.d("idKecamatanAsal", idKecamatanAsal);


            }
        });

        //MENDAPAT ID KECAMATAN
        KecamatanTujuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {

                int indeksSubdistrict = ListNamaKecamatanTujuan.indexOf(KecamatanTujuan.getText().toString());
                idKecamatanTujuan = String.valueOf(ListIdKecamatanTujuan.get(indeksSubdistrict));
                Log.d("idKecamatanTujuan", idKecamatanTujuan);

                new JSONParse("http://api.shipping.esoftplay.com/domesticCost/"+ idKecamatanAsal +"/"+idKecamatanTujuan+"/100/jne/subdistrict/subdistrict", "ongkosKirim").execute();


            }
        });

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        Button buttonPilihKurir = findViewById(R.id.button_pilih_kurir);

        myDialog = new Dialog(this);

        sheetView = this.getLayoutInflater().inflate(R.layout.popup_pilih_kurir, null);


        buttonPilihKurir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(sheetView);
                myDialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT );
                myDialog.show();

            }
        });


    }
    Dialog myDialog;
    View sheetView;

    private class JSONParse extends AsyncTask<String, String, JSONObject> {


        String url;
        String keterangan;

        JSONParse(String url, String keterangan) {
            this.url = url;
            this.keterangan = keterangan;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected JSONObject doInBackground(String... args) {



            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                if (keterangan.equals("kota")) {
                                    JSONArray jsonArray = response.getJSONArray("result");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        final JSONObject e = jsonArray.getJSONObject(i);
                                        String name = e.getString("city_name");
                                        ListKota.add(name);

                                    }
                                } else if (keterangan.equals("kecamatanAsal")) {
                                    JSONArray jsonArray = response.getJSONArray("result");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        final JSONObject e = jsonArray.getJSONObject(i);
                                        String subdistrict_name = e.getString("subdistrict_name");
                                        String subdistrict_id = e.getString("subdistrict_id");

                                        ListNamaKecamatanAsal.add(subdistrict_name);
                                        ListIdKecamatanAsal.add(subdistrict_id);

                                        Log.d("List", ListNamaKecamatanAsal.get(0));

                                        Log.d("kecamatan", subdistrict_id + subdistrict_name);


                                    }
                                } else if (keterangan.equals("kecamatanTujuan")) {

                                    JSONArray jsonArray = response.getJSONArray("result");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        final JSONObject e = jsonArray.getJSONObject(i);
                                        String subdistrict_name = e.getString("subdistrict_name");
                                        String subdistrict_id = e.getString("subdistrict_id");

                                        ListNamaKecamatanTujuan.add(subdistrict_name);
                                        ListIdKecamatanTujuan.add(subdistrict_id);

                                        Log.d("List", ListNamaKecamatanTujuan.get(0));

                                        Log.d("kecamatan", subdistrict_id + subdistrict_name);

                                    }
                                } else if (keterangan.equals("ongkosKirim")) {
                                    Log.d("Cok", "Cok");

                                    JSONArray result = response.getJSONArray("result");
                                    for (int i = 0; i < result.length(); i++) {
                                        final JSONObject e = result.getJSONObject(i);
                                        JSONArray costs = e.getJSONArray("costs");
                                        for (int j = 0; j < costs.length(); j++) {
                                            final JSONObject f = costs.getJSONObject(j);
                                            String service = f.getString("service");
                                            ListService.add(service);
                                            JSONArray cost = f.getJSONArray("cost");
                                            for(int k=0; k < cost.length(); k++){
                                                final JSONObject g = cost.getJSONObject(k);
                                                String harga = g.getString("value");
                                                String etd = g.getString("etd");

                                                ListService.add(harga);
                                                ListService.add(etd);
                                            }

                                        }


                                    }

                                    for(int z=0; z < ListService.size(); z++){
                                        ongkir.append(ListService.get(z));
                                    }



                                }else {

                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue.add(request);
            return null;


        }

        @Override
        protected void onPostExecute(JSONObject json) {
            progressBar.setVisibility(View.GONE);



        }
    }


}
