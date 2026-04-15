package com.tugas.deploy.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    // Simpan data sementara (tidak pakai database)
    private static List<Model> mahasiswaList = new ArrayList<>();

    private String nama;
    private String nim;
    private String jenisKelamin;

    public Model() {}

    public Model(String nama, String nim, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
    }

    public boolean checkLogin(String username, String password) {
        return username.equals("admin") && password.equals("160");
    }

    public static List<Model> getMahasiswaList() {
        return mahasiswaList;
    }

    public static void addMahasiswa(Model m) {
        mahasiswaList.add(m);
    }

    // Getter
    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getJenisKelamin() { return jenisKelamin; }
}