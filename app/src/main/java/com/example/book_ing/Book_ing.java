package com.example.book_ing;

import android.app.Application;

public final class Book_ing extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/arciform.otf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/arciform.otf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/arciform.otf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/arciform.otf");
    }
}
