package com.example.book_ing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FragmentBeranda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_beranda);

        TextView textViewNama = (TextView) findViewById(R.id.textViewNama);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String displayName = extras.getString("displayName");
            String displayEmail = extras.getString("displayEmail");
            textViewNama.setText(displayName);
            //The key argument here must match that used in the other activity
        }
    }
}
