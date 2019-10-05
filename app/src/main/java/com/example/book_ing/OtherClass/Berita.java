package com.example.book_ing.OtherClass;

import android.graphics.drawable.Drawable;

public class Berita {

    private String JudulBerita, RingkasanBerita;
    private Drawable ImageBerita;

    public Berita(String judulBerita, String ringkasanBuku) {
        JudulBerita = judulBerita;
        RingkasanBerita = ringkasanBuku;
    }

    public Berita(String judulBerita, String ringkasanBuku, Drawable imageBerita) {
        JudulBerita = judulBerita;
        RingkasanBerita = ringkasanBuku;
        ImageBerita = imageBerita;
    }

    public Drawable getImageBerita() {
        return ImageBerita;
    }

    public void setImageBerita(Drawable imageBerita) {
        ImageBerita = imageBerita;
    }

    public String getJudulBerita() {
        return JudulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        JudulBerita = judulBerita;
    }

    public String getRingkasanBerita() {
        return RingkasanBerita;
    }


    public void setRingkasanBerita(String ringkasanBerita) {
        RingkasanBerita = ringkasanBerita;
    }
}
