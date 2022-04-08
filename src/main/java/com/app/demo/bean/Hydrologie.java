package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hydrologie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courEau;
    private double surface;
    private double apportMoyenAnnuel;
    private double crueChentier;
    private double crueProjet;

    public Hydrologie() {
        this.courEau = null;
        this.surface = 0;
        this.apportMoyenAnnuel = 0;
        this.crueChentier = 0;
        this.crueProjet = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourEau() {
        return courEau;
    }

    public void setCourEau(String courEau) {
        this.courEau = courEau;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getApportMoyenAnnuel() {
        return apportMoyenAnnuel;
    }

    public void setApportMoyenAnnuel(double apportMoyenAnnuel) {
        this.apportMoyenAnnuel = apportMoyenAnnuel;
    }

    public double getCrueChentier() {
        return crueChentier;
    }

    public void setCrueChentier(double crueChentier) {
        this.crueChentier = crueChentier;
    }

    public double getCrueProjet() {
        return crueProjet;
    }

    public void setCrueProjet(double crueProjet) {
        this.crueProjet = crueProjet;
    }
}
