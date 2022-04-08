package com.app.demo.service;

import com.app.demo.Dao.BarrageDao;
import com.app.demo.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BarrageService {


    public List<Barrage> findAll() {
        return barrageDao.findAll();
    }

    public Barrage findByProvince(String province) {
        return barrageDao.findByProvince(province);
    }

    public Barrage findBySousBassin(String sousBassin) {
        return barrageDao.findBySousBassin(sousBassin);
    }

    public Barrage findByName(String name) {
        return barrageDao.findByName(name);
    }

    public int save(Barrage barrage) {
        DigueDeCol digueDeCol = digueDeColService.findByHauteurSurFondationAndLargeurCrete(barrage.getDigueDeCol().getHauteurSurFondation(), barrage.getDigueDeCol().getLargeurCrete());
        EvacuateurCrues evacuateurCrues = evacuateurCruesService.findByDebitMaxAndHauteurSeuil(barrage.getEvacuateurCrues().getDebitMax(), barrage.getEvacuateurCrues().getHauteurSeuil());
        Hydrologie hydrologie = hydrologieService.findByCourEauAndSurface(barrage.getHydrologie().getCourEau(), barrage.getHydrologie().getSurface());
        Retenue retenue = retenueService.findByNiveauRetenueNormalAndNiveauEauMax(barrage.getRetenue().getNiveauRetenueNormal(), barrage.getRetenue().getNiveauEauMax());
        VidangeFond vidangeFond = vidangeFondService.findByCoteSeuilEnterAndDebitMaxEvacue(barrage.getVidangeFond().getCoteSeuilEnter(), barrage.getVidangeFond().getDebitMaxEvacue());
        Gardien gardien = gardienService.findByCin(barrage.getGardien().getCin());

        if (digueDeCol != null) {
            barrage.setDigueDeCol(digueDeCol);
        } else {
            DigueDeCol deCol = new DigueDeCol();
            digueDeColService.save(deCol);
            barrage.setDigueDeCol(deCol);
        }

        if (evacuateurCrues != null) {
            barrage.setEvacuateurCrues(evacuateurCrues);
        } else {
            EvacuateurCrues deCol = new EvacuateurCrues();
            barrage.setEvacuateurCrues(deCol);
        }

        if (hydrologie != null) {
            barrage.setHydrologie(hydrologie);
        } else {
            Hydrologie hydro = new Hydrologie();
            barrage.setHydrologie(hydro);
        }

        if (retenue != null) {
            barrage.setRetenue(retenue);
        } else {
            Retenue retenu = new Retenue();
            barrage.setRetenue(retenu);
        }

        if (vidangeFond != null) {
            barrage.setVidangeFond(vidangeFond);
        } else {
            VidangeFond vf = new VidangeFond();
            barrage.setVidangeFond(vf);
        }


        barrage.setGardien(gardien);
        barrageDao.save(barrage);
        return 1;
    }

    @Transactional
    public int deleteByName(String name) {
        Barrage barrage = findByName(name);

        int r9 = gardienService.deleteById(barrage.getGardien().getId());
        int r7 = digueDeColService.deleteById(barrage.getDigueDeCol().getId());
        int r6 = evacuateurCruesService.deleteById(barrage.getEvacuateurCrues().getId());
        int r5 = hydrologieService.deleteById(barrage.getHydrologie().getId());
        int r4 = retenueService.deleteById(barrage.getRetenue().getId());
        int r3 = vidangeFondService.deleteById(barrage.getVidangeFond().getId());
        int r2 = situationBarrageService.deleteByBarrageName(name);
        int r1 = barrageDao.deleteByName(name);
        return r1 + r2 + r3 + r4 + r5 + r6 + r7 + r9;
    }

    @Autowired
    private BarrageDao barrageDao;
    @Autowired
    private DigueDeColService digueDeColService;
    @Autowired
    private EvacuateurCruesService evacuateurCruesService;
    @Autowired
    private HydrologieService hydrologieService;
    @Autowired
    private RetenueService retenueService;
    @Autowired
    private VidangeFondService vidangeFondService;
    @Autowired
    private SituationBarrageService situationBarrageService;
    @Autowired
    private GardienService gardienService;
}
