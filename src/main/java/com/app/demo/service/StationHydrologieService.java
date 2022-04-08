package com.app.demo.service;

import com.app.demo.bean.*;
import com.app.demo.Dao.StationHydrologieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class StationHydrologieService {


    public StationHydrologie findByNrePoste(String nrePoste) {
        return stationHydrologieDao.findByNrePoste(nrePoste);
    }

    @Transactional
    public int deleteByNrePoste(String nrePoste) {
        return stationHydrologieDao.deleteByNrePoste(nrePoste);
    }

    public StationHydrologie findBySousbassin(String sousbassin) {
        return stationHydrologieDao.findBySousbassin(sousbassin);
    }


    public StationHydrologie findByDateMiseEnService(Date dateMiseEnService) {
        return stationHydrologieDao.findByDateMiseEnService(dateMiseEnService);
    }

    public StationHydrologie findByProvince(String province) {
        return stationHydrologieDao.findByProvince(province);
    }

    public StationHydrologie findByNomStation(String nomStation) {
        return stationHydrologieDao.findByNomStation(nomStation);
    }

    public StationHydrologie findStationHydrologieById(long id) {
        return stationHydrologieDao.findStationHydrologieById(id);
    }

    @Transactional
    public int deleteByNomStaion(String nomStation) {
        StationHydrologie stationHydrologie = findByNomStation(nomStation);
        int r1 = batterieEchelleService.deleteByStationNomStation(nomStation);
        int r2 = gardienService.deleteById(stationHydrologie.getGardien().getId());
        int r4 = situationPluviometriqueService.deleteByStationHydrologieNomStation(nomStation);
        int r0 = stationHydrologieDao.deleteByNomStation(nomStation);
        return r0 + r1 + r2 + r4;
    }

    public List<StationHydrologie> findAll() {
        return stationHydrologieDao.findAll();
    }


    public int save(StationHydrologie stationHydrologie) {
        this.gardienService.findAll();
        if (stationHydrologie.getNomStation() == null) {
            return -1;
        } else {
            Gardien gardien = gardienService.findByCin(stationHydrologie.getGardien().getCin());
                stationHydrologie.setGardien(gardien);
                stationHydrologieDao.save(stationHydrologie);
                return 1;
        }
    }

    public  List<String>  ListLibelle(){
        List<String> list = new ArrayList<>();
        List<StationHydrologie> hydrologieList = this.findAll();
        List<Barrage> barrageList = this.barrageService.findAll();

        for (Barrage barrage: barrageList
             ) {
            list.add(barrage.getName());
        }
        for (StationHydrologie station: hydrologieList
             ) {
            list.add(station.getNomStation());
        }
        return list;
    }

    @Autowired
    private StationHydrologieDao stationHydrologieDao;
    @Autowired
    private BarrageService barrageService;
    @Autowired
    private GardienService gardienService;
    @Autowired
    private BatterieEchelleService batterieEchelleService;
    @Autowired
    private SituationPluviometriqueService situationPluviometriqueService;


}