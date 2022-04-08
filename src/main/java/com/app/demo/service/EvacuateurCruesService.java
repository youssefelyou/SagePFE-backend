package com.app.demo.service;

import com.app.demo.Dao.EvacuateurCruesDao;
import com.app.demo.bean.EvacuateurCrues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvacuateurCruesService {

    public int save(EvacuateurCrues evacuateurCrues ) {
        EvacuateurCrues ev = findByDebitMaxAndHauteurSeuil(evacuateurCrues.getDebitMax(),evacuateurCrues.getHauteurSeuil());
        if (ev == null){
            evacuateurCruesDao.save(evacuateurCrues);
            return 1;
        }else{
            return 0;
        }

    }

    public EvacuateurCrues findByDebitMaxAndHauteurSeuil(double debitMax, double hateurSeuil) {
        return evacuateurCruesDao.findByDebitMaxAndHauteurSeuil(debitMax, hateurSeuil);
    }

    public List<EvacuateurCrues> findAll() {
        return evacuateurCruesDao.findAll();
    }

    @Transactional
    public int deleteById(long id) {
        return evacuateurCruesDao.deleteEvacuateurCruesById(id);
    }
    @Autowired
    private EvacuateurCruesDao evacuateurCruesDao;
}
