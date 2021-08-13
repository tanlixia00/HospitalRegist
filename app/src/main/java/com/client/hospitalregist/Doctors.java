package com.client.hospitalregist;

public class Doctors {

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

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Doctors(int id, String nama, String spesialis, String phone) {
        this.id = id;
        this.nama = nama;
        this.spesialis = spesialis;
        this.phone = phone;
    }

    int id;
    String nama;
    String spesialis;
    String phone;
}
