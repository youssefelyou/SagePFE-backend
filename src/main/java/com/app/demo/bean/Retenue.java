package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Retenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double niveauRetenueNormal;
    private double niveauEauMax;
    private double surfaceRetenueNormal;
    private double volumeRetenueNormal;
    private double volumeRegularise;

    public Retenue() {
        this.niveauRetenueNormal = 0;
        this.niveauEauMax = 0;
        this.surfaceRetenueNormal = 0;
        this.volumeRetenueNormal = 0;
        this.volumeRegularise = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNiveauRetenueNormal() {
        return niveauRetenueNormal;
    }

    public void setNiveauRetenueNormal(double niveauRetenueNormal) {
        this.niveauRetenueNormal = niveauRetenueNormal;
    }

    public double getNiveauEauMax() {
        return niveauEauMax;
    }

    public void setNiveauEauMax(double niveauEauMax) {
        this.niveauEauMax = niveauEauMax;
    }

    public double getSurfaceRetenueNormal() {
        return surfaceRetenueNormal;
    }

    public void setSurfaceRetenueNormal(double surfaceRetenueNormal) {
        this.surfaceRetenueNormal = surfaceRetenueNormal;
    }

    public double getVolumeRetenueNormal() {
        return volumeRetenueNormal;
    }

    public void setVolumeRetenueNormal(double volumeRetenueNormal) {
        this.volumeRetenueNormal = volumeRetenueNormal;
    }

    public double getVolumeRegularise() {
        return volumeRegularise;
    }

    public void setVolumeRegularise(double volumeRegularise) {
        this.volumeRegularise = volumeRegularise;
    }
}
