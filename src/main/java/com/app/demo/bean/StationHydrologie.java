package com.app.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class StationHydrologie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nrePoste;
    private String nire;
    private String nomStation;
    private String province;
    private String commune;
    private String carte;
    private String statutFoncier;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateMiseEnService;
    private String oued;
    private Double surface;
    private String nature; //simplifie || principale
    private String sousbassin;
    private String localiteplusproche;
    private String typeStation;
    private String teletransmise;
    private String acces;
    private double x;
    private double y;
    private double z;

    @OneToMany(mappedBy = "station")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<SituationPluviometrique> situationPluviometrique = new ArrayList<>();

    @OneToMany(mappedBy = "station")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BatterieEchelle>  batterie; //list

    @OneToOne
    private Gardien gardien;


    public List<BatterieEchelle> getBatterie() {
        return batterie;
    }

    public void setBatterie(List<BatterieEchelle> batterie) {
        this.batterie = batterie;
    }

    public Gardien getGardien() {
        return gardien;
    }

    public void setGardien(Gardien gardien) {
        this.gardien = gardien;
    }

    public List<SituationPluviometrique> getSituationPluviometrique() {
        return situationPluviometrique;
    }

    public void setSituationPluviometrique(List<SituationPluviometrique> situationPluviometrique) {
        this.situationPluviometrique = situationPluviometrique;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNire() {
        return nire;
    }

    public void setNire(String nire) {
        this.nire = nire;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStatio) {
        nomStation = nomStatio;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public String getStatutFoncier() {
        return statutFoncier;
    }

    public void setStatutFoncier(String statutFoncier) {
        this.statutFoncier = statutFoncier;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnServic) {
        dateMiseEnService = dateMiseEnServic;
    }

    public String getOued() {
        return oued;
    }

    public void setOued(String oued) {
        this.oued = oued;
    }

    public Double getSurface() {
        return surface;
    }

    public String getTeletransmise() {
        return teletransmise;
    }

    public void setTeletransmise(String teletransmise) {
        this.teletransmise = teletransmise;
    }

    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public String getSousbassin() {
        return sousbassin;
    }

    public void setSousbassin(String sousbassin) {
        this.sousbassin = sousbassin;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getLocaliteplusproche() {
        return localiteplusproche;
    }

    public void setLocaliteplusproche(String localiteplusproche) {
        this.localiteplusproche = localiteplusproche;
    }

    public String getNrePoste() {
        return nrePoste;
    }

    public void setNrePoste(String nrePoste) {
        this.nrePoste = nrePoste;
    }


}