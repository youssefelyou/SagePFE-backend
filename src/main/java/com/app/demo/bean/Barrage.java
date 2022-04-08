package com.app.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Barrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ire;
    private String name;
    private String cr;
    private String province;
    private String type;
    private String type1;
    private String sousBassin;
    private String priseRestitution;
    private double hauteurSurFondation;
    private double niveauCrete;
    private double longueurEnCrete;
    private double largeurEnCrete;
    private double nmbrePrises; //Prises Eau Potable
    private double diametreConduite; //Prises Eau Potable
    private String oued;
    private int x;
    private int y;
    private int z;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateMiseService;
    @OneToMany(mappedBy = "barrage")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<SituationBarrages> situationBarrages = new ArrayList<>();
    @OneToOne
    private DigueDeCol digueDeCol;
    @OneToOne
    private EvacuateurCrues evacuateurCrues;
    @OneToOne
    private Hydrologie hydrologie;
    @OneToOne
    private Retenue retenue;
    @OneToOne
    private VidangeFond vidangeFond;

    @OneToOne
    private Gardien gardien;



    public Gardien getGardien() {
        return gardien;
    }

    public void setGardien(Gardien gardien) {
        this.gardien = gardien;
    }

    public List<SituationBarrages> getSituationBarrages() {
        return situationBarrages;
    }

    public void setSituationBarrages(List<SituationBarrages> situationBarrages) {
        this.situationBarrages = situationBarrages;
    }

    public DigueDeCol getDigueDeCol() {
        return digueDeCol;
    }

    public void setDigueDeCol(DigueDeCol digueDeCol) {
        this.digueDeCol = digueDeCol;
    }

    public EvacuateurCrues getEvacuateurCrues() {
        return evacuateurCrues;
    }

    public void setEvacuateurCrues(EvacuateurCrues evacuateurCrues) {
        this.evacuateurCrues = evacuateurCrues;
    }

    public Hydrologie getHydrologie() {
        return hydrologie;
    }

    public void setHydrologie(Hydrologie hydrologie) {
        this.hydrologie = hydrologie;
    }

    public Retenue getRetenue() {
        return retenue;
    }

    public void setRetenue(Retenue retenue) {
        this.retenue = retenue;
    }

    public VidangeFond getVidangeFond() {
        return vidangeFond;
    }

    public void setVidangeFond(VidangeFond vidangeFond) {
        this.vidangeFond = vidangeFond;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIre() {
        return ire;
    }

    public void setIre(String ire) {
        this.ire = ire;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getPriseRestitution() {
        return priseRestitution;
    }

    public void setPriseRestitution(String priseRestitution) {
        this.priseRestitution = priseRestitution;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateMiseService() {
        return dateMiseService;
    }

    public void setDateMiseService(Date dateMiseService) {
        this.dateMiseService = dateMiseService;
    }

    public String getSousBassin() {
        return sousBassin;
    }

    public void setSousBassin(String sousBassin) {
        this.sousBassin = sousBassin;
    }



    public double getHauteurSurFondation() {
        return hauteurSurFondation;
    }

    public void setHauteurSurFondation(double hauteurSurFondation) {
        this.hauteurSurFondation = hauteurSurFondation;
    }

    public double getNiveauCrete() {
        return niveauCrete;
    }

    public void setNiveauCrete(double niveauCrete) {
        this.niveauCrete = niveauCrete;
    }

    public double getLongueurEnCrete() {
        return longueurEnCrete;
    }

    public void setLongueurEnCrete(double longueurEnCrete) {
        this.longueurEnCrete = longueurEnCrete;
    }

    public double getLargeurEnCrete() {
        return largeurEnCrete;
    }

    public void setLargeurEnCrete(double largeurEnCrete) {
        this.largeurEnCrete = largeurEnCrete;
    }

    public double getNmbrePrises() {
        return nmbrePrises;
    }

    public void setNmbrePrises(double nmbrePrises) {
        this.nmbrePrises = nmbrePrises;
    }

    public double getDiametreConduite() {
        return diametreConduite;
    }

    public void setDiametreConduite(double diametreConduite) {
        this.diametreConduite = diametreConduite;
    }

    public String getOued() {
        return oued;
    }

    public void setOued(String oued) {
        this.oued = oued;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
