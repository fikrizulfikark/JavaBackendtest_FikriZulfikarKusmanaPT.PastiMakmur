package com.testbeackenddeveloper.fikrizulfikarkusmana.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Penilaian implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private MataPelajaran mataPelajaran;

    private double nilai;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MataPelajaran getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(MataPelajaran mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
}

