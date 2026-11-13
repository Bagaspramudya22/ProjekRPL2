package com.mycompany.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todocrud")
public class Tugas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nama_Tugas", nullable = false)
    private String namaTugas;

    @Column(name = "Tandai_Selesai")
    private String tandaSelesai;

    public Tugas() {
    }

    public Tugas(String namaTugas) {
        this.namaTugas = namaTugas;
        this.tandaSelesai = "Belum";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNamaTugas() { return namaTugas; }
    public void setNamaTugas(String namaTugas) { this.namaTugas = namaTugas; }

    public String getTandaSelesai() { return tandaSelesai; }
    public void setTandaSelesai(String tandaSelesai) { this.tandaSelesai = tandaSelesai; }
}