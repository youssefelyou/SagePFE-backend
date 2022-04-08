package com.app.demo.Dao;

import com.app.demo.bean.Retenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetenueDao extends JpaRepository<Retenue,Long> {
    Retenue findByNiveauRetenueNormalAndNiveauEauMax(double niveauRetenueNormal , double niveauEauMax);
    int deleteRetenuesById(long id);
}
