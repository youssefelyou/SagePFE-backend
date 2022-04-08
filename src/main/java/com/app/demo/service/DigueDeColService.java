package com.app.demo.service;

import com.app.demo.Dao.DigueDeColDao;
import com.app.demo.bean.DigueDeCol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DigueDeColService {
    public int save(DigueDeCol digueDeCol) {
        DigueDeCol digueDeCol1 = findByHauteurSurFondationAndLargeurCrete(digueDeCol.getHauteurSurFondation(),digueDeCol.getLargeurCrete());
        if (digueDeCol1 == null){
            digueDeColDao.save(digueDeCol);
            return 1;
        }else{
           return 0;
        }

    }

    public List<DigueDeCol> findAll() {
        return digueDeColDao.findAll();
    }

    public DigueDeCol findByHauteurSurFondationAndLargeurCrete(double hauteurSurFondation, double largeurCrete) {
        return digueDeColDao.findByHauteurSurFondationAndLargeurCrete(hauteurSurFondation, largeurCrete);
    }

    @Transactional
    public int deleteById(long id) {
        return digueDeColDao.deleteDigueDeColsById(id);
    }

    @Autowired
    private DigueDeColDao digueDeColDao;

}
