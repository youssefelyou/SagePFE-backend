package com.app.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VidangeFond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pertuisBeton;
    private double debitMaxEvacue;
    private double coteSeuilEnter;

    public VidangeFond() {
        this.pertuisBeton = null;
        this.debitMaxEvacue = 0;
        this.coteSeuilEnter = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPertuisBeton() {
        return pertuisBeton;
    }

    public void setPertuisBeton(String pertuisBeton) {
        this.pertuisBeton = pertuisBeton;
    }

    public double getDebitMaxEvacue() {
        return debitMaxEvacue;
    }

    public void setDebitMaxEvacue(double debitMaxEvacue) {
        this.debitMaxEvacue = debitMaxEvacue;
    }

    public double getCoteSeuilEnter() {
        return coteSeuilEnter;
    }

    public void setCoteSeuilEnter(double coteSeuilEnter) {
        this.coteSeuilEnter = coteSeuilEnter;
    }
}
