package com.app.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Gardien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomPrenom;
    private String cin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datenaissance;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date entrerFonction;
    private double age;
    private String niveauscolaire;
    private String situationfami;
    private double ntel;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date periode;
    private String situationadministrative;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNtel() {
        return ntel;
    }

    public void setNtel(double ntel) {
        this.ntel = ntel;
    }

    public String getNiveauscolaire() {
        return niveauscolaire;
    }

    public void setNiveauscolaire(String niveauscolaire) {
        this.niveauscolaire = niveauscolaire;
    }

    public String getSituationfami() {
        return situationfami;
    }

    public void setSituationfami(String situationfami) {
        this.situationfami = situationfami;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Date getPeriode() {
        return periode;
    }

    public void setPeriode(Date periode) {
        this.periode = periode;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Date getEntrerFonction() {
        return entrerFonction;
    }

    public void setEntrerFonction(Date entrerFonction) {
        this.entrerFonction = entrerFonction;
    }

    public String getSituationadministrative() {
        return situationadministrative;
    }

    public void setSituationadministrative(String situationadministrative) {
        this.situationadministrative = situationadministrative;
    }
}

