package com.app.demo.service;

import com.app.demo.Dao.RetenueDao;
import com.app.demo.bean.Observation;
import com.app.demo.bean.Retenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RetenueService {
    public int save(Retenue retenue ) {
        Retenue retenue1 = findByNiveauRetenueNormalAndNiveauEauMax(retenue.getNiveauRetenueNormal(),retenue.getNiveauEauMax());
        if (retenue1 == null){
            retenueDao.save(retenue);
            return 1;
        } else{
            return 0;
        }

    }

    public Retenue findByNiveauRetenueNormalAndNiveauEauMax(double niveauRetenueNormal, double niveauEauMax) {
        return retenueDao.findByNiveauRetenueNormalAndNiveauEauMax(niveauRetenueNormal, niveauEauMax);
    }

    public List<Retenue> findAll() {
        return retenueDao.findAll();
    }

    @Transactional
    public int deleteById(long id) {
        return retenueDao.deleteRetenuesById(id);
    }


    @Autowired
    private RetenueDao retenueDao;
}
