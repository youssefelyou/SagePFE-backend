package com.app.demo.Dao;

import com.app.demo.bean.SituationPluviometrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository()
public interface SituationPluviometriqueDao extends JpaRepository<SituationPluviometrique,Long> {

    List<SituationPluviometrique> findByDate(LocalDateTime date);
    List<SituationPluviometrique>  findByDateBetween(LocalDateTime dateDebit ,LocalDateTime dateFin);
    SituationPluviometrique findByDateAndStationNomStation(LocalDateTime date , String nomStation);

    List<SituationPluviometrique> findByStationNomStation(String nomStation);

    int deleteByStationNomStation(String nomStation);

}
