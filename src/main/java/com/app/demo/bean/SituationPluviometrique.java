package com.app.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class SituationPluviometrique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double pluie;
    private double neige;
    private double niveauEau;
    private double debit;
    private double hauteurmax;
    private double coteAlerte;
    private double cotePreAlerte;
    private double debitMax;
    private String heurDebitMax;
    private double debitPreAlerte;
    private double debitAlerte;
    @JsonFormat(pattern = "MM-dd-yyyy h:mm:ss a")
    private LocalDateTime date;
    @ManyToOne
    private StationHydrologie station;

    public StationHydrologie getStation() {
        return station;
    }

    public void setStation(StationHydrologie station) {
        this.station = station;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getNiveauEau() {
        return niveauEau;
    }

    public void setNiveauEau(double niveauEau) {
        this.niveauEau = niveauEau;
    }

    public double getHauteurmax() {
        return hauteurmax;
    }

    public void setHauteurmax(double hauteurmax) {
        this.hauteurmax = hauteurmax;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCoteAlerte() {
        return coteAlerte;
    }

    public void setCoteAlerte(double coteAlerte) {
        this.coteAlerte = coteAlerte;
    }

    public double getCotePreAlerte() {
        return cotePreAlerte;
    }

    public void setCotePreAlerte(double cotePreAlerte) {
        this.cotePreAlerte = cotePreAlerte;
    }

    public double getDebitMax() {
        return debitMax;
    }

    public void setDebitMax(double debitMax) {
        this.debitMax = debitMax;
    }

    public String getHeurDebitMax() {
        return heurDebitMax;
    }

    public void setHeurDebitMax(String heurDebitMax) {
        this.heurDebitMax = heurDebitMax;
    }

    public double getDebitPreAlerte() {
        return debitPreAlerte;
    }

    public void setDebitPreAlerte(double debitPreAlerte) {
        this.debitPreAlerte = debitPreAlerte;
    }

    public double getDebitAlerte() {
        return debitAlerte;
    }

    public void setDebitAlerte(double debitAlerte) {
        this.debitAlerte = debitAlerte;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}