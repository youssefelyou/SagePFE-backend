package com.app.demo.Dao;

import com.app.demo.bean.BaremeDebit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaremeDebitDao extends JpaRepository<BaremeDebit,Long> {
    BaremeDebit findByStationHydrologieNomStationAndHauteur(String nomStation, double hauteur);
    List<BaremeDebit> deleteByStationHydrologieNomStation(String nomStation);

}
