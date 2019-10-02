package com.example.book_ing.Welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.book_ing.Activity.ActivityBottomNavigation;
import com.example.book_ing.R;

public class ActivityDaftar extends AppCompatActivity {

    private Button ButtonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        ButtonDaftar = findViewById(R.id.button_daftar);

        ButtonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDaftar.this, ActivityBottomNavigation.class));
            }
        });
    }
}
