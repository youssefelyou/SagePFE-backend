package com.app.demo.service;

import com.app.demo.bean.StationClimatologique;
import com.app.demo.Dao.StationClimatologiqueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class StationClimatologiqueService {
    @Autowired
    private StationClimatologiqueDao stationClimatologiqueDao;

    public StationClimatologique findByName(String name) {
        return stationClimatologiqueDao.findByName(name);
    }

    public int deleteByName(String name) {
        return stationClimatologiqueDao.deleteByName(name);
    }

    public List<StationClimatologique> findAll() {
        return stationClimatologiqueDao.findAll();
    }

    public int save(StationClimatologique stationClimatologique) {

            stationClimatologiqueDao.save(stationClimatologique);
            return 1;
    }
}