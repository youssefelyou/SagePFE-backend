package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DigueDeCol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private double hauteurSurFondation;
    private double niveauCrete;
    private double longueurCrete;
    private double largeurCrete;

    public DigueDeCol() {
        this.type = null;
        this.hauteurSurFondation = 0;
        this.niveauCrete = 0;
        this.longueurCrete = 0;
        this.largeurCrete = 0;
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

    public double getHauteurSurFondation() {
        return hauteurSurFondation;
    }

    public void setHauteurSurFondation(double hauteurSurFondation) {
        this.hauteurSurFondation = hauteurSurFondation;
    }

    public double getNiveauCrete() {
        return niveauCrete;
    }

    public void setNiveauCrete(double niveauCrete) {
        this.niveauCrete = niveauCrete;
    }

    public double getLongueurCrete() {
        return longueurCrete;
    }

    public void setLongueurCrete(double longueurCrete) {
        this.longueurCrete = longueurCrete;
    }

    public double getLargeurCrete() {
        return largeurCrete;
    }

    public void setLargeurCrete(double largeurCrete) {
        this.largeurCrete = largeurCrete;
    }
}
