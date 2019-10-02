package com.example.book_ing;

public final class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/product_sans_regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/product_sans_regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/product_sans_regular.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/product_sans_regular.ttf");
    }
}

