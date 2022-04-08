package com.app.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class SituationBarrages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double debit;
    private double hauteurActuel;
    private double volumeActuel;
    private double tauxRemplissage;
    private double volumeNormal;
    private double pluie;
    private double neige;
    private double bac;
    @JsonFormat(pattern="MM-dd-yyyy h:mm:ss a")
    private LocalDateTime date;
    private double turbinage;
    private String irrigation;
    private String vidangeFond;
    private String evacuateurCrues;
    private String turbidite;
    @ManyToOne
    private Barrage barrage;
    @OneToOne
    private Observation observation;

    public Observation getObservation() {
        return observation;
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getHauteurActuel() {
        return hauteurActuel;
    }

    public void setHauteurActuel(double hauteurActuel) {
        this.hauteurActuel = hauteurActuel;
    }

    public double getVolumeActuel() {
        return volumeActuel;
    }

    public void setVolumeActuel(double volumeActuel) {
        this.volumeActuel = volumeActuel;
    }


    public double getTauxRemplissage() {
        return tauxRemplissage;
    }

    public void setTauxRemplissage(double tauxRemplissage) {
        this.tauxRemplissage = tauxRemplissage;
    }

    public double getPluie() {
        return pluie;
    }

    public void setPluie(double pluie) {
        this.pluie = pluie;
    }

    public double getNeige() {
        return neige;
    }

    public void setNeige(double neige) {
        this.neige = neige;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getVolumeNormal() {
        return volumeNormal;
    }

    public void setVolumeNormal(double volumeNormal) {
        this.volumeNormal = volumeNormal;
    }


    public double getTurbinage() {
        return turbinage;
    }

    public void setTurbinage(double turbinage) {
        this.turbinage = turbinage;
    }

    public String getIrrigation() {
        return irrigation;
    }

    public void setIrrigation(String irrigation) {
        this.irrigation = irrigation;
    }

    public String getVidangeFond() {
        return vidangeFond;
    }

    public void setVidangeFond(String vidangeFond) {
        this.vidangeFond = vidangeFond;
    }

    public String getEvacuateurCrues() {
        return evacuateurCrues;
    }

    public void setEvacuateurCrues(String evacuateurCrues) {
        this.evacuateurCrues = evacuateurCrues;
    }

    public String getTurbidite() {
        return turbidite;
    }

    public void setTurbidite(String turbidite) {
        this.turbidite = turbidite;
    }

    public Barrage getBarrage() {
        return barrage;
    }

    public void setBarrage(Barrage barrage) {
        this.barrage = barrage;
    }

    public double getBac() {
        return bac;
    }

    public void setBac(double bac) {
        this.bac = bac;
    }
}
