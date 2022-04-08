package com.app.demo.ws.vo;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class BaremeVo {
    private String nom;
    private Date dateTime;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
