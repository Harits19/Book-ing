package com.example.book_ing.Recyclerview_Kurir;

public class Kurir {

    private String Service, Harga, Estimasi;

    public Kurir(String service, String harga, String estimasi) {
        Service = service;
        Harga = harga;
        Estimasi = estimasi;
    }

    public Kurir() {

    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getEstimasi() {
        return Estimasi;
    }

    public void setEstimasi(String estimasi) {
        Estimasi = estimasi;
    }
}
