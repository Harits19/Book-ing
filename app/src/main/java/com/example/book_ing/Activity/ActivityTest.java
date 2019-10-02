package com.example.book_ing.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.book_ing.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ActivityTest extends AppCompatActivity {
    String url = "http://api.shipping.esoftplay.com/waybill/ALN53587/wahana";
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        mQueue = Volley.newRequestQueue(this);
        new JSONParseTrack("http://api.shipping.esoftplay.com/waybill/ALN53587/wahana").execute();






    }

    private class JSONParseTrack extends AsyncTask<String, String, JSONObject> {


        String url;
        String keterangan;
        private ProgressDialog pDialog;

        JSONParseTrack(String url) {

            this.url = url;
    }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            uid = (TextView)findViewById(R.id.uid);
//            name1 = (TextView)findViewById(R.id.name);
//            email1 = (TextView)findViewById(R.id.email);

            pDialog = new ProgressDialog(ActivityTest.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.d("bug", "bug");
                                JSONObject result = response.getJSONObject("result");
                                JSONObject summary = result.getJSONObject("summary");
                                String status = summary.getString("status");

                                JSONArray manifest = result.getJSONArray("manifest");

                                for(int i=0; i < manifest.length(); i++){
                                    final JSONObject indeks= manifest.getJSONObject(i);
                                    String manifest_code = indeks.getString("manifest_code");
                                    String manifest_description = indeks.getString("manifest_description");
                                    String manifest_date = indeks.getString("manifest_date");
                                    String manifest_time = indeks.getString("manifest_time");

                                    Log.d("aaaaa", manifest_time);
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
            pDialog.dismiss();


        }
    }

}

