package com.app.demo.service;


import com.app.demo.bean.SituationPluviometrique;
import com.app.demo.Dao.SituationPluviometriqueDao;
import com.app.demo.bean.StationHydrologie;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Service
public class SituationPluviometriqueService {
    @JsonFormat(pattern = "yyyy-MM-dd h:mm:ss")
    public LocalDateTime dat;
    @JsonFormat(pattern = "yyyy-MM-dd h:mm:ss")
    public LocalDateTime date1;

    public List<SituationPluviometrique> findByDate(String date) {
        this.dat = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        return situationPluviometriqueDao.findByDate(this.dat);
    }

    public SituationPluviometrique findByDateAndStationNomStation(String date, String nomStation) {
        this.date1 = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        return situationPluviometriqueDao.findByDateAndStationNomStation(this.date1, nomStation);
    }


    public List<SituationPluviometrique> findByDateBetween(String dateDebit, String dateFin) {
        this.date1 = LocalDateTime.parse(dateDebit, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        this.dat = LocalDateTime.parse(dateFin, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        return situationPluviometriqueDao.findByDateBetween(this.date1, this.dat);
    }

    @Transactional
    public int deleteByStationHydrologieNomStation(String nomStation) {
        return situationPluviometriqueDao.deleteByStationNomStation(nomStation);
    }


    public List<SituationPluviometrique> findAll() {
        return situationPluviometriqueDao.findAll();
    }

    public int save(SituationPluviometrique s) {
        StationHydrologie stationHydrologie = stationHydrologieService.findByNomStation(s.getStation().getNomStation());
        if (stationHydrologie == null) {
            return -1;
        } else {
            s.setStation(stationHydrologie);
            situationPluviometriqueDao.save(s);
            return 1;
        }

    }

    public List<SituationPluviometrique> findByStationHydrologieNomStation(String nomStation) {
        return situationPluviometriqueDao.findByStationNomStation(nomStation);
    }

    @Autowired
    private SituationPluviometriqueDao situationPluviometriqueDao;

    @Autowired
    private StationHydrologieService stationHydrologieService;
}