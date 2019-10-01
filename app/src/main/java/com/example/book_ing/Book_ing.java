package com.example.book_ing;

import android.app.Application;

public final class Book_ing extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/product_sans_regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/arciform.otf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/product_sans_regular.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/product_sans_regular.ttf");
    }
}
