package com.app.demo.ws.vo;

import com.app.demo.bean.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class SituationJournaliereVo {
    private double pluie;
    private double neige;
    private String province;
    private String oued;
    private double niveauEau;
    private double niveauEauYesterday;
    private double debit;
    private double hauteurmax;
    private double coteAlerte;
    private double cotePreAlerte;
    private double debitMax;
    private String heurDebitMax;
    private double debitPreAlerte;
    private double debitAlerte;
    private double volumeActuel;
    private double volumeYesterday;
    private double varationVolume;
    private double tauxRemplissage;
    private double volumeNormal;
    private String date;
    private double turbinage;
    private String irrigation;
    private String sousBassin;
    private String vidangeFond;
    private String evacuateurCrues;
    private String turbidite;
    private String libelle; // nom de station ou de barrage

//private Barrage barrage;//private StationHydrologie station;

    // observation
    private double bac;
    private double cam;
    private double cmg;
    private String fuits;
    private double cr;
    private double aep;
    private double bp;
    //

    public double getPluie() {
        return pluie;
    }

    public void setPluie(double pluie) {
        this.pluie = pluie;
    }

    public String getOued() {
        return oued;
    }

    public void setOued(String oued) {
        this.oued = oued;
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

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getHauteurmax() {
        return hauteurmax;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setHauteurmax(double hauteurmax) {
        this.hauteurmax = hauteurmax;
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

    public double getNiveauEauYesterday() {
        return niveauEauYesterday;
    }

    public void setNiveauEauYesterday(double niveauEauYesterday) {
        this.niveauEauYesterday = niveauEauYesterday;
    }

    public String getSousBassin() {
        return sousBassin;
    }

    public void setSousBassin(String sousBassin) {
        this.sousBassin = sousBassin;
    }

    public double getVolumeYesterday() {
        return volumeYesterday;
    }

    public void setVolumeYesterday(double volumeYesterday) {
        this.volumeYesterday = volumeYesterday;
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


    public double getVolumeActuel() {
        return volumeActuel;
    }

    public void setVolumeActuel(double volumeActuel) {
        this.volumeActuel = volumeActuel;
    }

    public double getVarationVolume() {
        return varationVolume;
    }

    public void setVarationVolume(double varationVolume) {
        this.varationVolume = varationVolume;
    }

    public double getTauxRemplissage() {
        return tauxRemplissage;
    }

    public void setTauxRemplissage(double tauxRemplissage) {
        this.tauxRemplissage = tauxRemplissage;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getBac() {
        return bac;
    }

    public void setBac(double bac) {
        this.bac = bac;
    }

    public double getCam() {
        return cam;
    }

    public void setCam(double cam) {
        this.cam = cam;
    }

    public double getCmg() {
        return cmg;
    }

    public void setCmg(double cmg) {
        this.cmg = cmg;
    }

    public String getFuits() {
        return fuits;
    }

    public void setFuits(String fuits) {
        this.fuits = fuits;
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public double getAep() {
        return aep;
    }

    public void setAep(double aep) {
        this.aep = aep;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }
}
