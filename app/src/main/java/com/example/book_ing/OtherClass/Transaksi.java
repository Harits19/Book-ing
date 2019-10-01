package com.example.book_ing.OtherClass;

public class Transaksi {

    private String JudulBuku, WaktuPinjam, Pengarang;

    public Transaksi(String judulBuku, String waktuPinjam, String pengarang) {
        JudulBuku = judulBuku;
        WaktuPinjam = waktuPinjam;
        Pengarang = pengarang;
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
