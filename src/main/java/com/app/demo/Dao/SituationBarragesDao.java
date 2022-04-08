package com.app.demo.Dao;

import com.app.demo.bean.SituationBarrages;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface SituationBarragesDao extends JpaRepository<SituationBarrages, Long> {
    List<SituationBarrages> findByDate(@JsonFormat(pattern = "MM-dd-yyyy h:mm:ss") LocalDateTime date);

    SituationBarrages findByDateAndBarrageName(@JsonFormat(pattern = "MM-dd-yyyy h:mm:ss") LocalDateTime date, String name);

    List<SituationBarrages> findByBarrageName(String name);

    List<SituationBarrages> findByDateBetween(LocalDateTime dateDebit, LocalDateTime dateFin);

    List<SituationBarrages> findByDateBetweenAndBarrageName(LocalDateTime dateDebit, LocalDateTime dateFin, String name);

    int deleteByBarrageName(String name);

    //
//    @Query("select distinct SituationBarrages.date FROM SituationBarrages s WHERE " +
//            "s.date BETWEEN :dateDebut AND :dateFin")
//    List<Date> listDateBetween(@Param("dateDebut") LocalDateTime dateDebut, @Param("dateFin") LocalDateTime dateFin);
}
