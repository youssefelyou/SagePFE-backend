package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double cam;
    private double cmg;
    private String fuits;
    private double cr;
    private double aep;
    private double bp;

    public Observation() {
        this.cam = 0;
        this.cmg = 0;
        this.fuits = "";
        this.cr = 0;
        this.aep = 0;
        this.bp = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
