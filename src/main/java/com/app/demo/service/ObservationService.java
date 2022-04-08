package com.app.demo.service;

import com.app.demo.Dao.ObservationDao;
import com.app.demo.bean.Hydrologie;
import com.app.demo.bean.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObservationService {

    public int save(Observation observation) {
        Observation observation1 = this.findByAepAndBpAndCmgAndCamAndFuitsAndCr(observation.getAep(),
                observation.getBp(), observation.getCmg(), observation.getCam(),observation.getFuits(),
                observation.getCr());
        if (observation1 == null) {
            observationDao.save(observation);
            return 1;
        } else {
            return 0;
        }
    }

    public List<Observation> findAll() {
        return observationDao.findAll();
    }

    public Observation findByAepAndBpAndCmgAndCamAndFuitsAndCr(double aep, double bp, double cmg, double cam, String fuits, double cr) {
        return observationDao.findByAepAndBpAndCmgAndCamAndFuitsAndCr(aep, bp, cmg, cam, fuits, cr);
    }

    public Observation findById(long id) {
        return observationDao.findById(id);
    }

    @Transactional
    public int deleteById(long id) {
        return observationDao.deleteObservationsById(id);
    }

    @Autowired
    private ObservationDao observationDao;
}
