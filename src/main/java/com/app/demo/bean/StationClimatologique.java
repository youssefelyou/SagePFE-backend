package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StationClimatologique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double pluie;
    private double neige;
    private String vent;
    private String directionVent;
    private String rayonnement;
    private String humidite;
    private String evaporation;
    private String temperatureSec;
    private String temperatureMouille;
    private String temperatureMin;
    private String temperatureMax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVent() {
        return vent;
    }

    public void setVent(String vent) {
        this.vent = vent;
    }

    public String getDirectionVent() {
        return directionVent;
    }

    public void setDirectionVent(String directionVent) {
        this.directionVent = directionVent;
    }

    public String getRayonnement() {
        return rayonnement;
    }

    public void setRayonnement(String rayonnement) {
        this.rayonnement = rayonnement;
    }

    public String getHumidite() {
        return humidite;
    }

    public void setHumidite(String humidite) {
        this.humidite = humidite;
    }

    public String getEvaporation() {
        return evaporation;
    }

    public void setEvaporation(String evaporation) {
        this.evaporation = evaporation;
    }

    public String getTemperatureSec() {
        return temperatureSec;
    }

    public void setTemperatureSec(String temperatureSec) {
        this.temperatureSec = temperatureSec;
    }

    public String getTemperatureMouille() {
        return temperatureMouille;
    }

    public void setTemperatureMouille(String temperatureMouille) {
        this.temperatureMouille = temperatureMouille;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }


}