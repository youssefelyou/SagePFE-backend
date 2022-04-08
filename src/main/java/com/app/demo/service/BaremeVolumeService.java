package com.app.demo.service;

import com.app.demo.Dao.BaremeVolumeDao;
import com.app.demo.bean.BaremeVolume;
import com.app.demo.bean.Barrage;
import com.app.demo.bean.StationHydrologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaremeVolumeService {

    public BaremeVolume findByBarrageNameAndCote(String name, double cote) {
        return baremeVolumeDao.findByBarrageNameAndCote(name, cote);
    }



//    public List<Double> findVolumeActuel(String nom, double c) {
//        return baremeVolumeDao.findVolumeActuel(nom, c);
//    }

    @Transactional
    public List<BaremeVolume> deleteByBarrageName(String name) {
        return baremeVolumeDao.deleteByBarrageName(name);
    }

    public List<BaremeVolume> findAll() {
        return baremeVolumeDao.findAll();
    }

    public int save(BaremeVolume baremeVolume) {
        Barrage barrage = barrageService.findByName(baremeVolume.getBarrage().getName());
        baremeVolume.setBarrage(barrage);
        baremeVolumeDao.save(baremeVolume);
        return 1;
    }

    @Autowired
    private BaremeVolumeDao baremeVolumeDao;
    @Autowired
    private BarrageService barrageService;
}
