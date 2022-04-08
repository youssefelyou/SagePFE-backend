package com.app.demo.Dao;

import com.app.demo.bean.BatterieEchelle;
import com.app.demo.bean.SituationPluviometrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatterieEchelleDao extends JpaRepository<BatterieEchelle, Long> {
    BatterieEchelle findById(long id);
    int deleteBatterieEchellesById(long id);
    BatterieEchelle findByMax(double max);
    BatterieEchelle findByNre(double nre);
    List<BatterieEchelle> findByStationNomStation(String nomStation);
    int deleteByStationNomStation(String nomStation);
}
