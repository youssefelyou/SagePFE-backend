package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EvacuateurCrues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private double longueurDeversante;
    private double hauteurSeuil;
    private String largeurChenalRestitution;
    private double cruesProjet;
    private double debitMax;

    public EvacuateurCrues() {
        this.type = null;
        this.longueurDeversante = 0;
        this.hauteurSeuil = 0;
        this.largeurChenalRestitution = null;
        this.cruesProjet = 0;
        this.debitMax = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLongueurDeversante() {
        return longueurDeversante;
    }

    public void setLongueurDeversante(double longueurDeversante) {
        this.longueurDeversante = longueurDeversante;
    }

    public double getHauteurSeuil() {
        return hauteurSeuil;
    }

    public void setHauteurSeuil(double hauteurSeuil) {
        this.hauteurSeuil = hauteurSeuil;
    }

    public String getLargeurChenalRestitution() {
        return largeurChenalRestitution;
    }

    public void setLargeurChenalRestitution(String largeurChenalRestitution) {
        this.largeurChenalRestitution = largeurChenalRestitution;
    }

    public double getCruesProjet() {
        return cruesProjet;
    }

    public void setCruesProjet(double cruesProjet) {
        this.cruesProjet = cruesProjet;
    }

    public double getDebitMax() {
        return debitMax;
    }

    public void setDebitMax(double debitMax) {
        this.debitMax = debitMax;
    }
}
