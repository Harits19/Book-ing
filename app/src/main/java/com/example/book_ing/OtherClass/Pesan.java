package com.example.book_ing.OtherClass;

import android.widget.ImageView;

public class Pesan {

    private String PengirimPesan, RingkasanPesan, WaktuPesan;
    private ImageView ProfilPengirimPesan;

    public Pesan(String pengirimPesan, String ringkasanPesan, String waktuPesan, ImageView profilPengirimPesan) {
        PengirimPesan = pengirimPesan;
        RingkasanPesan = ringkasanPesan;
        WaktuPesan = waktuPesan;
        ProfilPengirimPesan = profilPengirimPesan;
    }

    public String getPengirimPesan() {
        return PengirimPesan;
    }

    public void setPengirimPesan(String pengirimPesan) {
        PengirimPesan = pengirimPesan;
    }

    public String getRingkasanPesan() {
        return RingkasanPesan;
    }

    public void setRingkasanPesan(String ringkasanPesan) {
        RingkasanPesan = ringkasanPesan;
    }

    public String getWaktuPesan() {
        return WaktuPesan;
    }

    public void setWaktuPesan(String waktuPesan) {
        WaktuPesan = waktuPesan;
    }

    public ImageView getProfilPengirimPesan() {
        return ProfilPengirimPesan;
    }

    public void setProfilPengirimPesan(ImageView profilPengirimPesan) {
        ProfilPengirimPesan = profilPengirimPesan;
    }
}
