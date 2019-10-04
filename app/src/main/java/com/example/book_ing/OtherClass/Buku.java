package com.example.book_ing.OtherClass;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Buku {

    private String JudulBuku, JaminanBuku, Pengarang, Pemilik, Lokasi, Terpinjam, Isbn;
    Drawable ImageViewBuku;

    public Drawable getImageViewBuku() {
        return ImageViewBuku;
    }

    public void setImageViewBuku(Drawable imageViewBuku) {
        this.ImageViewBuku = imageViewBuku;
    }

    public Buku(String judulBuku, String jaminanBuku) {
        JudulBuku = judulBuku;
        JaminanBuku = jaminanBuku;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public Buku(String judulBuku, String jaminanBuku, String isbn) {
        JudulBuku = judulBuku;
        JaminanBuku = jaminanBuku;
        Isbn = isbn;
    }

    public Buku(String judulBuku, String jaminanBuku, Drawable imageViewBuku) {
        JudulBuku = judulBuku;
        JaminanBuku = jaminanBuku;
        ImageViewBuku = imageViewBuku;
    }


    public Buku(String judulBuku, String jaminanBuku, String pengarang, String pemilik, String lokasi, String terpinjam) {
        JudulBuku = judulBuku;
        JaminanBuku = jaminanBuku;
        Pengarang = pengarang;
        Pemilik = pemilik;
        Terpinjam = terpinjam;
        Lokasi = lokasi;
    }

    public Buku(String judulBuku, String jaminanBuku, String pengarang, String pemilik, String lokasi, String terpinjam, Drawable imageViewBuku) {
        JudulBuku = judulBuku;
        JaminanBuku = jaminanBuku;
        Pengarang = pengarang;
        Pemilik = pemilik;
        Terpinjam = terpinjam;
        Lokasi = lokasi;
        ImageViewBuku = imageViewBuku;
    }

    public String getTerpinjam() {
        return Terpinjam;
    }

    public void setTerpinjam(String terpinjam) {
        Terpinjam = terpinjam;
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

    public String getPemilik() {
        return Pemilik;
    }

    public void setPemilik(String pemilik) {
        Pemilik = pemilik;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public void setPengarang(String pengarang) {
        Pengarang = pengarang;
    }

    public String getJaminanBuku() {
        return JaminanBuku;
    }


    public void setJaminanBuku(String JaminanBuku) {
        JaminanBuku = JaminanBuku;
    }
}
