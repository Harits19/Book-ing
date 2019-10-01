package com.example.book_ing.OtherClass;

public class Berita {

    private String JudulBerita, RingkasanBerita;

    public Berita(String judulTantangan, String poin) {
        JudulBerita = judulTantangan;
        RingkasanBerita = poin;
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
