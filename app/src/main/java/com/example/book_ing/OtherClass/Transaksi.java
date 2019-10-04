package com.example.book_ing.OtherClass;

import android.graphics.drawable.Drawable;

public class Transaksi {

    private String JudulBuku, WaktuPinjam, Pengarang, PemilikBuku;
    private Drawable drawableBukuTransaksi;

    public Drawable getDrawableBukuTransaksi() {
        return drawableBukuTransaksi;
    }

    public void setDrawableBukuTransaksi(Drawable drawableBukuTransaksi) {
        this.drawableBukuTransaksi = drawableBukuTransaksi;
    }

    public Transaksi(String judulBuku, String pemilikBuku, String pengarang, Drawable DrawableBukuTransaksi) {
        JudulBuku = judulBuku;
        WaktuPinjam = pemilikBuku;
        Pengarang = pengarang;
        drawableBukuTransaksi = DrawableBukuTransaksi;
    }

    public String getPemilikBuku() {
        return PemilikBuku;
    }

    public void setPemilikBuku(String pemilikBuku) {
        PemilikBuku = pemilikBuku;
    }

    public String getJudulBuku() {
        return JudulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        JudulBuku = judulBuku;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String pengarang) {
        Pengarang = pengarang;
    }

    public String getWaktuPinjam() {
        return WaktuPinjam;
    }


    public void setWaktuPinjam(String JaminanBuku) {
        JaminanBuku = JaminanBuku;
    }
}
