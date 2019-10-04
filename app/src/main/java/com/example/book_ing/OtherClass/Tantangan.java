package com.example.book_ing.OtherClass;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Tantangan {

    private String JudulTantangan, Poin;
    private Drawable ImageViewTantangan;

    public Drawable getImageViewTantangan() {
        return ImageViewTantangan;
    }

    public void setImageViewTantangan(Drawable imageViewTantangan) {
        ImageViewTantangan = imageViewTantangan;
    }

    public Tantangan(String judulTantangan, String poin) {
        JudulTantangan = judulTantangan;
        Poin = poin;
    }

    public Tantangan(String judulTantangan, String poin, Drawable imageViewTantangan) {
        JudulTantangan = judulTantangan;
        Poin = poin;
        ImageViewTantangan = imageViewTantangan;
    }

    public String getJudulTantangan() {
        return JudulTantangan;
    }

    public void setJudulTantangan(String judulTantangan) {
        JudulTantangan = judulTantangan;
    }

    public String getPoin() {
        return Poin;
    }


    public void setPoin(String poin) {
        Poin = poin;
    }
}
