package com.app.demo.Dao;

import com.app.demo.bean.StationHydrologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository()
public interface StationHydrologieDao extends JpaRepository<StationHydrologie,Long> {

    StationHydrologie findByNrePoste(String nrePoste);
    StationHydrologie findStationHydrologieById(long id);
    StationHydrologie findByProvince(String province);
    StationHydrologie findBySousbassin(String sousbassin);
    StationHydrologie findByDateMiseEnService(Date dateMiseEnService);
    StationHydrologie findByNomStation(String nomStation);
    int deleteByNomStation(String nomStation);
    int deleteByNrePoste(String nrePoste);

}