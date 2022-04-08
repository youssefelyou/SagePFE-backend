package com.app.demo.Dao;

import com.app.demo.bean.Bareme;
import com.app.demo.ws.vo.BaremeVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

@Repository
public interface BaremeDao extends JpaRepository<Bareme,Long> {
    List<Bareme> findByDateTime(Date dateTime);
    List<Bareme> findByNom(String nom);
    List<Bareme> findByDateTimeAndNomOrderByHauteur(Date dateTime , String nom);
    @Query("SELECT DISTINCT b.dateTime FROM Bareme b WHERE b.nom = :nomStation")
    List<Date> findBareme(@Param("nomStation") String nomStation);
}
