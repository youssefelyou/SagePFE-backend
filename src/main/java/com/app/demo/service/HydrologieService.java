package com.app.demo.service;

import com.app.demo.Dao.HydrologieDao;
import com.app.demo.bean.EvacuateurCrues;
import com.app.demo.bean.Hydrologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HydrologieService {
    public int save(Hydrologie hydrologie ) {
        Hydrologie hydro = findByCourEauAndSurface(hydrologie.getCourEau(),hydrologie.getSurface());
        if (hydro == null){
            hydrologieDao.save(hydrologie);
            return 1;
        }else{
            return 0;
        }

    }

    public Hydrologie findByCourEauAndSurface(String courEau, double surface) {
        return hydrologieDao.findByCourEauAndSurface(courEau, surface);
    }

    public List<Hydrologie> findAll() {
        return hydrologieDao.findAll();
    }

    @Transactional
    public int deleteById(long id) {
        return hydrologieDao.deleteHydrologiesById(id);
    }
    @Autowired
    private HydrologieDao hydrologieDao;
}
