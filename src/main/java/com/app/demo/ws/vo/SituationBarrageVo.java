package com.app.demo.ws.vo;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SituationBarrageVo {
    private String barrage;
    private LocalDateTime date;
    private double pluie;
    private double debit;
    private double volumeActuel;
    private double bac;
    private double tr;
    private double volumeNormal;

    public double getVolumeNormal() {
        return volumeNormal;
    }

    public void setVolumeNormal(double volumeNormal) {
        this.volumeNormal = volumeNormal;
    }

    public String getBarrage() {
        return barrage;
    }

    public void setBarrage(String barrage) {
        this.barrage = barrage;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getPluie() {
        return pluie;
    }

    public void setPluie(double pluie) {
        this.pluie = pluie;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getVolumeActuel() {
        return volumeActuel;
    }

    public void setVolumeActuel(double volumeActuel) {
        this.volumeActuel = volumeActuel;
    }

    public double getBac() {
        return bac;
    }

    public void setBac(double bac) {
        this.bac = bac;
    }

    public double getTr() {
        return tr;
    }

    public void setTr(double tr) {
        this.tr = tr;
    }
}
