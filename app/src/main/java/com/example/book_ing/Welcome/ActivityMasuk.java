package com.example.book_ing.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_ing.ActivityBottomNavigation;
import com.example.book_ing.R;

public class ActivityMasuk extends AppCompatActivity {

    private Button ButtonMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        ButtonMasuk = findViewById(R.id.button_masuk);

        ButtonMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ActivityMasuk.this, ActivityBottomNavigation.class));

            }
        });
    }
}
