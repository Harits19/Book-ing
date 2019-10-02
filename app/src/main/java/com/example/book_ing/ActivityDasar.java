package com.example.book_ing;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public abstract class ActivityDasar extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}