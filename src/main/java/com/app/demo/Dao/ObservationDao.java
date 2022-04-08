package com.app.demo.Dao;

import com.app.demo.bean.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationDao extends JpaRepository<Observation,Long> {
    Observation findById(long id);
    Observation findByAepAndBpAndCmgAndCamAndFuitsAndCr(double aep, double bp, double cmg, double cam,
                         String fuits, double cr);
    int deleteObservationsById(long id);
}
