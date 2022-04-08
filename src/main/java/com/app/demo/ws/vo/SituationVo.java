package com.app.demo.ws.vo;

import com.app.demo.bean.SituationPluviometrique;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SituationVo {
    private String libelle;
    private LocalDateTime date ;
    private double pluie;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
}
