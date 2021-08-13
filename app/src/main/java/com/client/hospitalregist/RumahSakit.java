package com.client.hospitalregist;

public class RumahSakit {

    int id;
    String nama;

    public RumahSakit(int id, String nama, String lokasi_text, String lati, String longi) {
        this.id = id;
        this.nama = nama;
        this.lokasi_text = lokasi_text;
        this.lati = lati;
        this.longi = longi;
    }

    String lokasi_text;
    String lati;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi_text() {
        return lokasi_text;
    }

    public void setLokasi_text(String lokasi_text) {
        this.lokasi_text = lokasi_text;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    String longi;


}
