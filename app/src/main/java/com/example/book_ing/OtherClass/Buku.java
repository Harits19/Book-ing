package com.example.book_ing.OtherClass;

public class Buku {

    private String JudulBuku, JaminanBuku, Pengarang;

    public Buku(String judulBuku, String jaminanBuku) {
        JudulBuku = judulBuku;
        JaminanBuku = jaminanBuku;
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

    public String getJaminanBuku() {
        return JaminanBuku;
    }


    public void setJaminanBuku(String JaminanBuku) {
        JaminanBuku = JaminanBuku;
    }
}
