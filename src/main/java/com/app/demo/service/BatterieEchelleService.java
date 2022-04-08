package com.app.demo.service;

import com.app.demo.bean.BatterieEchelle;
import com.app.demo.Dao.BatterieEchelleDao;
import com.app.demo.bean.StationHydrologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BatterieEchelleService {

    @Autowired
    private BatterieEchelleDao batterieEchelleDao;
    @Autowired
    private StationHydrologieService stationHydrologieService;

    public BatterieEchelle findById(long id) {
        return batterieEchelleDao.findById(id);
    }

    public BatterieEchelle findByMax(double max) {
        return batterieEchelleDao.findByMax(max);
    }

    @Transactional
    public int deleteBatterieEchellesById(long id) {
        return batterieEchelleDao.deleteBatterieEchellesById(id);
    }

    public List<BatterieEchelle> findAll() {
        return batterieEchelleDao.findAll();
    }

    public List<BatterieEchelle> findByStationNomStation(String nomStation) {
        return batterieEchelleDao.findByStationNomStation(nomStation);
    }

    public int deleteByStationNomStation(String nomStation) {
        return batterieEchelleDao.deleteByStationNomStation(nomStation);
    }

    public int save(BatterieEchelle batterieEchelle) {
        if (batterieEchelle.getNre() == 0){
            return -1;
        }else {
            StationHydrologie  stationHydrologie = stationHydrologieService.findByNomStation(batterieEchelle.getStation().getNomStation());
            batterieEchelle.setStation(stationHydrologie);
            batterieEchelleDao.save(batterieEchelle);
            return 1;
        }
    }

    public BatterieEchelle findByNre(double nre) {
        return batterieEchelleDao.findByNre(nre);
    }
}



