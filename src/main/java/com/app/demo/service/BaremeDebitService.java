package com.app.demo.service;

import com.app.demo.Dao.BaremeDebitDao;
import com.app.demo.bean.BaremeDebit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.demo.bean.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BaremeDebitService {

    public BaremeDebit findByStationHydrologieNomStationAndHauteur(String nomStation, double hauteur) {
        return baremeDebitDao.findByStationHydrologieNomStationAndHauteur(nomStation, hauteur);
    }

    public int saveAll(List<BaremeDebit> baremeDebits) {
         baremeDebitDao.saveAll(baremeDebits);
         return 1;
    }

    public List<BaremeDebit> findAll() {
        return baremeDebitDao.findAll();
    }

    public int save(BaremeDebit baremeDebit) {
        StationHydrologie stationHydrologie = stationHydrologieService.findByNomStation(baremeDebit.getStationHydrologie().getNomStation());
         baremeDebit.setStationHydrologie(stationHydrologie);
        baremeDebitDao.save(baremeDebit);
         return 1;
    }

    @Transactional
    public List<BaremeDebit> deleteByStationHydrologieNomStation(String nomStation) {
        return baremeDebitDao.deleteByStationHydrologieNomStation(nomStation);
    }

    public Optional<BaremeDebit> findById(Long aLong) {
        return baremeDebitDao.findById(aLong);
    }

    @Autowired
    private BaremeDebitDao baremeDebitDao;
    @Autowired
    private StationHydrologieService stationHydrologieService;
}
