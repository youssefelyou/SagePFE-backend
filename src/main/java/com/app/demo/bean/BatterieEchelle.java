package com.app.demo.bean;

import javax.persistence.*;

@Entity
public class BatterieEchelle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double nre;
    private double min;
    private double max;
    @ManyToOne
    private StationHydrologie station;

    public StationHydrologie getStation() {
        return station;
    }

    public void setStation(StationHydrologie station) {
        this.station = station;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getNre() {
        return nre;
    }

    public void setNre(double nre) {
        this.nre = nre;
    }
}
